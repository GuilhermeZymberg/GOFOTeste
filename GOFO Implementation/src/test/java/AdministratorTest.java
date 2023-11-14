package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlayGroundSchedule;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  private Administrator administrator;
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    //InputStream sysInBackup = System.in;
    administrator = new Administrator();
    
    Playground abcd = new Playground();
    PlayGroundSchedule e = new PlayGroundSchedule();
    abcd.setSchedule(e);
    //String input = "sp";
    //String status = "available";
    //String beggining = "12";
    //String end = "14";
    //String price = "1";
    
    //InputStream in = new ByteArrayInputStream(input.getBytes());
    
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    systemIn.provideLines("sp");
    abcd.setLocation();
    systemIn.provideLines("available");
    abcd.setStatus();
    
    abcd.setCancellationPeriod(2);
    systemIn.provideLines("12", "14");
    e.setschedule();
    systemIn.provideLines("1");
    abcd.setPrice();
    
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    InputStream sysInBackup = System.in;
    systemIn.provideLines("12","1","12");
    int res = administrator.bookByName("bolo","jose",100);
    
    assertEquals(1,res);
  }
}
