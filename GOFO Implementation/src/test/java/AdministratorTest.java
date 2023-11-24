package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlayGroundSchedule;
import System.Player;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  private Administrator administrator;
  private Playground play1;
  private Playground play2;
  private Player p;
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    administrator = new Administrator();
    Player p = new Player();
    Playground play1 = new Playground();
    Playground play2 = new Playground();

    //player setup

    p.setBalance(1);
    //UC02 - Playground Setup
    //play1 setup 
    play1.setName("Bão");
    play1.setOwner("Jonas");
    systemIn.provideLines("sp");
    play1.setLocation();
    systemIn.provideLines("available");
    play1.setStatus();
    play1.setCancellationPeriod(2);
    systemIn.provideLines("1", "5");
    play1.setBooking();
    systemIn.provideLines("1");
    play1.setPrice();

    //play2 setup 
    play2.setName("Bad");
    play2.setOwner("Pedro");
    systemIn.provideLines("sbc");
    play2.setLocation();
    systemIn.provideLines("not available");
    play2.setStatus();
    play2.setCancellationPeriod(4);
    systemIn.provideLines("1", "4");
    play2.setBooking();
    systemIn.provideLines("50");
    play2.setPrice();
    
    administrator.playgroundRequests(play1);
    systemIn.provideLines("yes");
    administrator.approvePlayground();
  }
  @Test
  public void testBookByName(){
    System.out.println("----TESTE BOOK BY NAME----");
    systemIn.provideLines("4","1","sunday"); //hora: 1h, duração de 1h, no dia 12
    int res = administrator.bookByName("Bão","jose",100); 
    
    assertEquals(1,res); //marcado com sucesso e preço é igual a um
    System.out.println("----FIM BOOK BY NAME----");
  }
  @Test
  public void testBookByLocations(){
    System.out.println("----TESTE BOOK BY LOCATION----");
    systemIn.provideLines("1","1","monday"); //hora: 1h, duração de 1h, no dia 12
    int res = administrator.bookByLocation("sp","james",51); 
    assertEquals(50,res);
    System.out.println("----FIM BOOK BY LOCATION----");
  }
  @Test
  public void getApprovedTest(){
    System.out.println("----TESTE APPROVED----");
    administrator.getApproved();
    System.out.println("----FIM----");
  }
  @Test
  public void playgroundRequestsTest(){
    System.out.println("----TESTE REQUESTS----");
    administrator.playgroundRequests(play2);
    System.out.println("----FIM----");
  }
  @Test
  public void approvePlaygroundTest(){
    System.out.println("----TESTE APPROVEPLAY---");
    systemIn.provideLines("yes");
    administrator.approvePlayground();
    System.out.println("----FIM----");
  }
  @Test
  public void displayAllPlaygroundsTest(){
    System.out.println("----TESTE DISPLAY ALL---");
    administrator.displayAllPlaygrounds();
    System.out.println("----FIM----");
  }
  @Test
  public void searchByNameTest(){
    System.out.println("----TESTE SEARCH BY NAME----");
    administrator.searchByName("Bão");
    System.out.println("----FIM----");
  }
  @Test
  public void searchByLocationTest(){
    System.out.println("----TESTE SEARCH BY LOCATION----");
    administrator.searchByLocation("sp");
    System.out.println("----FIM----");
  }
  @Test
  public void displayAllavailablePlaygroundsLocationsTest(){
    System.out.println("----TESTE DISPLAY ALL LOCATION----");
    administrator.displayAllavailablePlaygroundsLocations();
    System.out.println("----FIM----");
  }
  @Test
  public void displayAllavailablePlaygroundsNamesTest(){
    System.out.println("----TESTE DISPLAY ALL NAME----");
    administrator.displayAllavailablePlaygroundsNames();
    System.out.println("----FIM----");
  }
  @Test
  public void addComplaintsTest(){
    System.out.println("----TESTE ADD COMPLAINT----");
    administrator.addComplaints("odeio o parque aff");
    System.out.println("----FIM----");
  }
  @Test
  public void showComplaintsTest(){
    System.out.println("----TESTE SHOW COMPLAINTS----");
    administrator.showComplaints();
    System.out.println("----FIM---");
  }
  @Test
  public void getEmailTest(){
    System.out.println("----TESTE GET EMAIL----");
    assertEquals("admin@gmail.com",administrator.getEmail());
    System.out.println("----FIM----");
  }
  @Test
  public void getPasswordTest(){
    System.out.println("----TESTE GET PASSWORD----");
    assertEquals("123",administrator.getPassword());
    System.out.println("----FIM----");
  }
  @Test
  public void suspendPlaygroundTest(){
    System.out.println("----TESTE SUSPEND PLAY----");
    administrator.suspendPlayground("Bão"); 
    System.out.println("----FIM----");
  }
  @Test
  public void unSuspendPlaygroundTest(){
    System.out.println("----TEST UNSUSPEND PLAY----");
    systemIn.provideLines("yes");
    administrator.unSuspendPlayground();
    System.out.println("----FIM----");
  }
  @Test
  public void deletePlaygroundTest(){
    System.out.println("----TEST DELETE PLAYGROUND----");
    administrator.deletePlayground("Bão");
    System.out.println("----FIM----");
  }
}
