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
    systemIn.provideLines("1","gui");
    p.editPlayerinfo();
    systemIn.provideLines("2","z");
    p.editPlayerinfo();
    systemIn.provideLines("3","7");
    p.editPlayerinfo();
    systemIn.provideLines("4","gui@gm.com");
    p.editPlayerinfo();
    systemIn.provideLines("5","11");
    p.editPlayerinfo();
    systemIn.provideLines("7,","1234");
    p.editPlayerinfo(); 
    
    pt.setFName("gui");
    pt.setLName("z");
    pt.setID(7);
    pt.setEmail("gui@gm.com");
    pt.setPhone(11);
    pt.setPassword("1234");
    
    assertEquals(pt.getFullName(),p.getFullName());
    assertEquals(pt.getPassword(),p.getPassword());
    assertEquals(pt.getID(),p.getID());
    assertEquals(pt.getPhone(),p.getPhone());
    assertEquals(pt.getEmail(),p.getEmail());
  }
}
