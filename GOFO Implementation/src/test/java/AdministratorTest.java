package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlayGroundSchedule;
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
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    administrator = new Administrator();
    
    Playground play1 = new Playground();
    Playground play2 = new Playground();

    //play1 setup 
    play1.setName("Bão");
    play1.setOwner("Jonas");
    systemIn.provideLines("sp");
    play1.setLocation();
    systemIn.provideLines("available");
    play1.setStatus();
    play1.setCancellationPeriod(2);
    systemIn.provideLines("12", "14");
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
    administrator.playgroundRequests(play2);
    systemIn.provideLines("yes","yes");
    administrator.approvePlayground();
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    systemIn.provideLines("12","1","12"); //hora: 1h, duração de 1h, no dia 12
    int res = administrator.bookByName("Bão","jose",100); 
    
    assertEquals(1,res); //marcado com sucesso e preço é igual a um
  }
  @Test
  public void testBookByLocations(){
    systemIn.provideLines("2","1","3"); //hora: 1h, duração de 1h, no dia 12
    int res = administrator.bookByLocation("sbc","james",50); 
    assertEquals(50,res);
  }
}
