package codigo.src;
import System.userProfile;
import UI.SystemUI;
import System.Player;
import System.PlaygroundOwner;
import System.eWallet;
import java.io.*;
import java.util.ArrayList;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UC01ExceptionTest{
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
    public void registerExceptionTest(){
      exit.expectSystemExitWithStatus(0);
      systemIn.provideLines("2","2","z", "7","1234", "gui@gm.com","11", "sp","player","50","bolinha","3"); //option, fname, lname, ID, pass, email, phone, loc, balance, validation code, option
      s.accountMenu();
    }
}
