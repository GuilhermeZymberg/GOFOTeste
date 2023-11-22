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
  
  private Administrator administrator;
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    p = new Player();
    pt = new Player();
  }
  @Test
  public void editPlayerInfoTest(){
    systemIn.provideLines("1","gui","2","z","3","7","4","gui@gm.com","5","11","6","sp","7,","1234"); //fname, lname, id, email, phone, loc, password
    p.editPlayerInfo();
    p.editPlayerInfo();
    p.editPlayerInfo();
    p.editPlayerInfo();
    p.editPlayerInfo();
    p.editPlayerInfo();
    p.editPlayerInfo();
    p.setBalance();
    pt.setFName("gui");
    pt.setLName("z");
    pt.setPassword("1234");
    pt.setID(7);
    pt.setRule("player");
    pt.setPhone(11);
    pt.setEmail("gui@gm.com");
    pt.setLocation("sp"); 
    assertEquals(pt.getBalance(),p.getBalance());
    assertEquals(pt.getFullName(),p.getFullName());
    assertEquals(pt.getPassword(),p.getPassword());
    assertEquals(pt.getID(),p.getID());
    assertEquals(pt.getRule(),p.getRule());
    assertEquals(pt.getPhone(),p.getPhone());
    assertEquals(pt.getEmail(),p.getEmail());
  }
}
