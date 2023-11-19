package codigo.src;
import System.userProfile;
import UI.SystemUI;
import static UI.SystemUI.thePlayers;
import static UI.SystemUI.theOwners;
import System.Player;
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
  static ArrayList<Player> players = new ArrayList<Player>();
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    p = new Player();
    s = new SystemUI();
    user1 = new userProfile();
    user2 = new userProfile();
  }
  @Test
  public void registerTest(){
    System.out.println("----REGISTRATION TEST----");
    System.out.println("--Main Flow--");
    systemIn.provideLines("50","gui","z", "7","1234", "gui@gm.com","11", "sp","player"); //balance, fname, lname, ID, pass, email, phone, loc
    s.register();
    p.setBalance(50);
    p.setFName("gui");
    p.setLName("z");
    p.setPassword("1234");
    p.setID(7);
    p.setRule("player");
    p.setPhone(11);
    p.setEmail("gui@gm.com");
    p.setLocation("sp");
    assertEquals(p,s.thePlayers.get(0));
  }
  public void registerExceptionTest(){
    System.out.println("----REGISTRATION TEST----");
    System.out.println("--Exception Flow--");
    systemIn.provideLines("50","2","clara","r", "5","5678", "clahrck@gm.com","52", "rs","playground owner"); //balance, invalid, fname, lname, ID, pass, email, phone, loc
    s.register();
    p.setBalance(50);
    p.setFName("clara");
    p.setLName("r");
    p.setPassword("5678");
    p.setID(5);
    p.setRule("playground owner");
    p.setPhone(52);
    p.setEmail("clahrck@gm.com");
    p.setLocation("rs");
    assertEquals(p,s.theOwners.get(0));
    System.out.println("----END OF REGISTRATION TEST----");
  }
}
