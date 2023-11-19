package codigo.src;
import System.userProfile;
import UI.SystemUI;
import System.Player;
import System.PlaygroundOwner;
import java.io.*;
import java.util.ArrayList;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UserRegistrationTest{
  private userProfile user1;
  private userProfile user2;
  private SystemUI s;
  private Player p;
  private PlaygroundOwner pg;
  static ArrayList<Player> players = new ArrayList<Player>();
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    p = new Player();
    pg =  new PlaygroundOwner();
    s = new SystemUI();
    user1 = new userProfile();
    user2 = new userProfile();
  }
  @Test
  public void registerTest(){
    System.out.println("----REGISTRATION TEST----");
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
    System.out.println(p.equals(s.getThePlayers().get(0)));
                       
    assertEquals(p,s.getThePlayers().get(0));
  }
  public void registerExceptionTest(){
    System.out.println("----REGISTRATION TEST----");
    System.out.println("--Exception Flow--");
    systemIn.provideLines("2","clara","r", "5","5678", "clahrck@gm.com","52", "rs","playground owner","50"); // invalid, fname, lname, ID, pass, email, phone, loc, balance
    s.register();
    systemIn.provideLines("50");
    pg.setBalance();
    pg.setFName("clara");
    pg.setLName("r");
    pg.setPassword("5678");
    pg.setID(5);
    pg.setRule("playground owner");
    pg.setPhone(52);
    pg.setEmail("clahrck@gm.com");
    pg.setLocation("rs");
    assertEquals(p,s.getThePlayers().get(0));
    System.out.println("----END OF REGISTRATION TEST----");
  }
}
