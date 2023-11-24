package codigo.src;
import System.Player;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PlayerTest{
  
  private Player p;
  private Player pt;
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    p = new Player();
    pt = new Player();
  }
  @Test
  public void editPlayerinfoTest(){
    System.out.println("----TESTE EDIT PLAYER INFO----");
    systemIn.provideLines("1","gui");
    p.editPlayerinfo();
    systemIn.provideLines("2","z");
    p.editPlayerinfo();
    systemIn.provideLines("3","13");
    p.editPlayerinfo();
    systemIn.provideLines("4","gui@gm.com");
    p.editPlayerinfo();
    systemIn.provideLines("5","11");
    p.editPlayerinfo();
    systemIn.provideLines("7","1234");
    p.editPlayerinfo(); 
    
    pt.setFName("gui");
    pt.setLName("z");
    pt.setID(13);
    pt.setEmail("gui@gm.com");
    pt.setPhone(11);
    pt.setPassword("1234");
    
    assertEquals(pt.getFullName(),p.getFullName());
    assertEquals(pt.getPassword(),p.getPassword());
    assertEquals(pt.getID(),p.getID());
    assertEquals(pt.getPhone(),p.getPhone());
    assertEquals(pt.getEmail(),p.getEmail());
    System.out.println("----FIM----");
  }
  @Test
  public void setBalanceTest(){
    System.out.println("----TESTE SET BALANCE----");
    systemIn.provideLines("100");
    System.out.println("----FIM----");
  }
  @Test
  public void bookingSlotsTest(){
    System.out.println("----TESTE BOOKING SLOTS----");
    p.bookingSlots("2","Bão");
    System.out.println("----FIM----");
  }
  @Test
  public void cancelBookingTest(){
    System.out.println("----TESTE CANCEL BOOKING----");
    p.bookingSlots("3","Bom");
    p.CancelBooking("Bom","3");
    System.out.println("----FIM----");
  }
  @Test
  public void getBalanceTest(){
    System.out.println("----TESTE GET BALANCE----");
    p.setBalance(1);
    assertEquals(1,p.getBalance());
    System.out.println("----FIM----");
  }
  @Test
  public void createTeamTest(){
    System.out.println("----TESTE CREATE TEAM----");
    p.createTeam(p);
    System.out.println("----FIM----");
  }
  @Test
  public void getMoneyTest(){
    System.out.println("----TESTE GET MONEY----");
    p.setBalance(0);
    p.getMoney(20);
    assertEquals(20,p.getBalance());
    System.out.println("----FIM----");
  }
  @Test
  public void addInboxTest(){
    System.out.println("----TESTE ADD INBOX----");
    p.addInbox("oiiiieeeeeee!!!!");
    System.out.println("----FIM----");
  }
  @Test
  public void viewInboxTest(){
    System.out.println("----TESTE ADD INBOX----");
    p.addInbox("oiiiieeeeeee!!!!");
    p.addInbox("uhuuuuuuul!!!!");
    p.addInbox("alegria!!!!");
    p.addInbox("ódio.");
    p.viewInbox();
    System.out.println("----FIM----");
  }
  
}
