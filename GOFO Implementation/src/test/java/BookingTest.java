package codigo.src;
import System.Administrator;
import System.Playground;
import System.Player;
import UI.PlayerUI;

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
    systemIn.provideLines("1");
    p.setPrice();
    administrator.playgroundRequests(play1);
    systemIn.provideLines("yes");
    administrator.approvePlayground();
    
    //p1 setup
    //p2 setup
    //p3 setup
    /* isso tudo no test incluindo os setup de cima ai
    p1.createTeam(p2);
    p1.createTeam(p3);
    ps.add(p1);
    ps.add(p2);
    ps.add(p3);
    int beforeBal = p1.getBalance();
    systemIn.provideLines("2","Teste");
    Scanner input = new Scanner(System.in);
    pu.Booking(input,p1.getID(),ps,p1.getEmail(),p1.getBalance());
    assertEquals(beforeBal - 1, p1.getBalance()); //teste booking
    */
    
  }
}
