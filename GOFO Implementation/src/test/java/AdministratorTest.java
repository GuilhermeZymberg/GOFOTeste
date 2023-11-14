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
    
    abcd.setStatus();
    systemIn.provideLines("available");
    abcd.setCancellationPeriod(2);
    abcd.setBooking();
    systemIn.provideLines("12");
    systemIn.provideLines("14");
    abcd.setPrice();
    systemIn.provideLines("1");
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    InputStream sysInBackup = System.in;
    int res = administrator.bookByName("bolo","jose",100);
    systemIn.provideLines("12");
    systemIn.provideLines("1");
    systemIn.provideLines("12");
    assertEquals(1,res);
  }
}
