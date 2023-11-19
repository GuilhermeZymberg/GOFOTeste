package codigo.src;
import System.userProfile;
import UI.SystemUI;
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
  private Player p;
  private userProfile user;
  private SystemUI s;
  static ArrayList<Player> players = new ArrayList<Player>();
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    p = new Player();
    user = new userProfile();
  }
  @Test
  public void editPlayerInfoTest(){
    System.out.println("----REGISTRATION TEST----");
    systemIn.provideLines("1","gui"); //fname
    p.editPlayerinfo();
    systemIn.provideLines("2","ze"); //lname
    p.editPlayerinfo();
    assertEquals("gui ze", p.getFullName());
    systemIn.provideLines("3","7"); //ID
    p.editPlayerinfo();
    systemIn.provideLines("4","gui@gm.com"); //email
    p.editPlayerinfo();
    systemIn.provideLines("7","1234"); //password
    p.editPlayerinfo();
    systemIn.provideLines("5","(11) 99999-9999"); //phone
    p.editPlayerinfo();
    systemIn.provideLines("6","7"); //location
    p.editPlayerinfo();
    players.add(p);
    p.obj.thePlayers.add(p);
    assertEquals(players,p.obj.thePlayer);
  }
}
