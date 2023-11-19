package codigo.src;
import System.userProfile;
import UI.SystemUI;
import System.Player;
import java.io.*;
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
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    p = new Player();
    user = new userProfile();
    s = new SystemUI();
  }
  @Test
  public void editPlayerInfoTest(){
    systemIn.provideLines("1","gui");
    p.editPlayerinfo();
    systemIn.provideLines("2","ze");
    p.editPlayerinfo();
    System.out.println(p.getFullName());
    assertEquals("gui ze", p.getFullName());
  }
}
