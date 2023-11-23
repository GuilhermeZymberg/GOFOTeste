package codigo.src;
import System.userProfile;
import UI.SystemUI;
import System.Player;
import System.PlaygroundOwner;
import System.eWallet;
import java.io.*;
import java.util.ArrayList;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UC01Test{
  private userProfile user1;
  private userProfile user2;
  private SystemUI s;
  private Player p;
  private PlaygroundOwner pg;
  private eWallet e;
  static ArrayList<Player> players = new ArrayList<Player>();
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    e = new eWallet();
    p = new Player();
    pg =  new PlaygroundOwner();
    s = new SystemUI();
    user1 = new userProfile();
    user2 = new userProfile();
  }
  @Test
  public void registerTest(){
    System.out.println("----UC01 - REGISTRATION TEST----");
    System.out.println("--Main Flow--");
    systemIn.provideLines("gui","z", "7","1234", "gui@gm.com","11", "sp","player","50"); //balance, fname, lname, ID, pass, email, phone, loc, balance
    s.register();
    systemIn.provideLines("50");
    p.setBalance();
    p.setFName("gui");
    p.setLName("z");
    p.setPassword("1234");
    p.setID(7);
    p.setRule("player");
    p.setPhone(11);
    p.setEmail("gui@gm.com");
    p.setLocation("sp"); 
    assertEquals(p.getBalance(),s.getThePlayers().get(0).getBalance());
    assertEquals(p.getFullName(),s.getThePlayers().get(0).getFullName());
    assertEquals(p.getPassword(),s.getThePlayers().get(0).getPassword());
    assertEquals(p.getID(),s.getThePlayers().get(0).getID());
    assertEquals(p.getRule(),s.getThePlayers().get(0).getRule());
    assertEquals(p.getPhone(),s.getThePlayers().get(0).getPhone());
    assertEquals(p.getEmail(),s.getThePlayers().get(0).getEmail());
  }
  public void registerExceptionTest(){
    System.out.println("--Exception Flow--");
    systemIn.provideLines("2","clara","r", "5","5678", "clahrck@gm.com","52", "rs","playground owner","50"); // invalid, fname, lname, ID, pass, email, phone, loc, balance
    s.register();
    systemIn.provideLines("50");
    e.setBalance();
    pg.setBalance(e);
    pg.setFName("clara");
    pg.setLName("r");
    pg.setPassword("5678");
    pg.setID(5);
    pg.setRule("playground owner");
    pg.setPhone(52);
    pg.setEmail("clahrck@gm.com");
    pg.setLocation("rs");
    assertEquals(pg.getMyBalance(),s.getTheOwners().get(0).getMyBalance());
    assertEquals(pg.getFullName(),s.getTheOwners().get(0).getFullName());
    assertEquals(pg.getPassword(),s.getTheOwners().get(0).getPassword());
    assertEquals(pg.getID(),s.getTheOwners().get(0).getID());
    assertEquals(pg.getRule(),s.getTheOwners().get(0).getRule());
    assertEquals(pg.getPhone(),s.getTheOwners().get(0).getPhone());
    assertEquals(pg.getEmail(),s.getTheOwners().get(0).getEmail());
    System.out.println("----UC01 - END OF REGISTRATION TEST----");
  }
}
