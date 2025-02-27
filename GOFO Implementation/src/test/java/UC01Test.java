package codigo.src;
import System.userProfile;
import UI.SystemUI;
import System.Player;
import System.PlaygroundOwner;
import System.eWallet;
import java.io.*;
import java.util.ArrayList;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
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
  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();
  
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
    exit.expectSystemExitWithStatus(0);
    systemIn.provideLines("2","gui","z", "7","1234", "gui@gm.com","11", "sp","player","50","bolinha","3"); //option, fname, lname, ID, pass, email, phone, loc, balance, validation code, option
    s.accountMenu();
    /*systemIn.provideLines("50");
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
    assertEquals(p.getEmail(),s.getThePlayers().get(0).getEmail());*/
  }
}
