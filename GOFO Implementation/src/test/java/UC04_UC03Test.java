package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlaygroundOwner;
import System.Player;
import System.eWallet;
import UI.PlayerUI;
import java.util.ArrayList;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertNotEquals;

public class UC04_UC03Test{
  private Administrator administrator;
  private Player p1;
  private Player p2;
  private Player p3;
  private Playground p;
  private PlayerUI pu;
  private ArrayList<Player> ps;
  private PlaygroundOwner po;
  private eWallet e;
  private String free;
  @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
  @Before
  public void setUp(){
    free = "";
    p = new Playground();
    administrator = new Administrator();
    ps = new ArrayList<Player>();
    p1 = new Player();
    p2 = new Player();
    p3 = new Player();
    po = new PlaygroundOwner();
    //po setup
    e = new eWallet();
    
    //playground setup
    p.setName("Teste");
    p.setOwner("Robinson");
    systemIn.provideLines("mg");
    p.setLocation();
    systemIn.provideLines("available");
    p.setStatus();
    p.setCancellationPeriod(2);
    systemIn.provideLines("1", "5");
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
    
    //p2 setup
    systemIn.provideLines("50");
    p2.setBalance();
    p2.setFName("mo");
    p2.setLName("mo");
    p2.setPassword("din");
    p2.setID(5);
    p2.setRule("player");
    p2.setPhone(99);
    p2.setEmail("momo@gml.com");
    p2.setLocation("mt");
    //p3 setup
    systemIn.provideLines("50");
    p3.setBalance();
    p3.setFName("titi");
    p3.setLName("toto");
    p3.setPassword("xddd");
    p3.setID(8);
    p3.setRule("player");
    p3.setPhone(56);
    p3.setEmail("tito@gml.com");
    p3.setLocation("tt");

    p1.createTeam(p2);
    p1.createTeam(p3);
    ps.add(p1);
    ps.add(p2);
    ps.add(p3);

    systemIn.provideLines("50");
    e.setBalance();
    po.setBalance(e);
    po.setFName("mario");
    po.setLName("kart");
    po.setPassword("yoy");
    po.setID(33);
    po.setRule("player");
    po.setPhone(1);
    po.setEmail("murilo@gml.com");
    po.setLocation("mk");
    po.addPlayground(p);
    
    //setup for cancelbooking assertion
    systemOutRule.clearLog();
    p.freeSlots();
    free = systemOutRule.getLog();
  }
  @Test
  public void bookTest(){
    System.out.println("----UC04 - BOOKING TEST----");
    System.out.println("--Main Flow--");
    int beforeBal = p1.getBalance();
    systemIn.provideLines("3","2","sunday");
    assertEquals(beforeBal - 10, p1.getBalance() - administrator.bookByName("Teste",p1.getFullName(),p1.getBalance())); //teste booking
    for(int i = 1; i < ps.size(); i++){
      ps.get(i).addInbox("Invited for "+ p.getName() + " from 3 to 5 PM at sunday");
      systemOutRule.clearLog();
      ps.get(i).viewInbox(); //verificar se impressão foi que estava vazia ou não
      assertEquals("Message No.1: Invited for "+ p.getName() + " from 3 to 5 PM at sunday\n", systemOutRule.getLog());
    }
    
  }
  @Test
  public void bookingExceptionTest(){
    System.out.println("--Exception Flow--");
    systemIn.provideLines("not available");
    p.setStatus();
    systemIn.provideLines("3","2","sunday"); //as 3 - 5, sunday
    assertEquals(10,administrator.bookByName("Teste",p1.getFullName(),p1.getBalance())); //expected error, should ask for new status but will return 5
    System.out.println("----END OF UC04 - BOOKING TEST----");
  }
  @Test
  public void cancelBookingTest(){
    System.out.println("----UC03 - CANCEL BOOKING TEST----");
    System.out.println("--Main Flow--");
    p1.CancelBooking("Teste","3");
    for(int i = 3; i < 5; i++){
      p.cancelBooking("sunday",Integer.toString(i));
    }
    systemIn.provideLines("available");
    p.setStatus();
    systemOutRule.clearLog();
    p.freeSlots();
    assertEquals(free,systemOutRule.getLog());
    System.out.println("----END OF UC03 - CANCEL BOOKING TEST----");
  }
}
