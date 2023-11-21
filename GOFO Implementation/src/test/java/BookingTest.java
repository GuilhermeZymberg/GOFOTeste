package codigo.src;
import System.Administrator;
import System.Playground;
import System.Player;
import UI.PlayerUI;
import java.util.ArrayList;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BookingTest{
  private Administrator administrator;
  private Player p1;
  private Player p2;
  private Player p3;
  private Playground p;
  private PlayerUI pu;
  private ArrayList<Player> ps;
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    p = new Playground();
    administrator = new Administrator();
    ps = new ArrayList<Player>();
    p1 = new Player();
    p2 = new Player();
    p3 = new Player();
    System.out.println("----UC04 - BOOKING TEST----");
    System.out.println("--Main Flow--");
    //playground setup
    p.setName("Teste");
    p.setOwner("Robinson");
    systemIn.provideLines("mg");
    p.setLocation();
    systemIn.provideLines("available");
    p.setStatus();
    p.setCancellationPeriod(2);
    systemIn.provideLines("1", "4");
    p.setBooking();
    systemIn.provideLines("5");
    p.setPrice();
    administrator.playgroundRequests(p);
    systemIn.provideLines("yes");
    administrator.approvePlayground();
    
    //p1 setup - user and balance
    systemIn.provideLines("50");
    p1.setBalance();
    p1.setFName("gege");
    p1.setLName("akutami");
    p1.setPassword("abcd");
    p1.setID(10);
    p1.setRule("player");
    p1.setPhone(24);
    p1.setEmail("gege@gml.com");
    p1.setLocation("jj");
    systemIn.provideLines("50");
    
    //p2 setup
    systemIn.provideLines("50");
    p2.setBalance();
    p2.setFName("gege");
    p2.setLName("akutami");
    p2.setPassword("abcd");
    p2.setID(10);
    p2.setRule("player");
    p2.setPhone(24);
    p2.setEmail("gege@gml.com");
    p2.setLocation("jj");
    //p3 setup
    systemIn.provideLines("50");
    p3.setBalance();
    p3.setFName("gege");
    p3.setLName("akutami");
    p3.setPassword("abcd");
    p3.setID(10);
    p3.setRule("player");
    p3.setPhone(24);
    p3.setEmail("gege@gml.com");
    p3.setLocation("jj");

    p1.createTeam(p2);
    p1.createTeam(p3);
    ps.add(p1);
    ps.add(p2);
    ps.add(p3);
    
  }
  @Test
  public void bookTest(){
    
    int beforeBal = p1.getBalance();
    systemIn.provideLines("3","2","sunday");
    assertEquals(beforeBal - 10, p1.getBalance() - administrator.bookByName("Teste",p1.getFullName(),p1.getBalance())); //teste booking
    for(int i = 1; i < ps.size(); i++){
      ps.get(i).addInbox("Invited for"+ p.getName() + "from 3 to 5 PM at sunday");
      ps.get(i).viewInbox(); //verificar se impressão foi que estava vazia ou não
    }
    
  }
}
