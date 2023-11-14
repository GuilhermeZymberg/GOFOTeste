package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlayGroundSchedule;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  private Administrator administrator;

  @Before
  public void setUp(){
    InputStream sysInBackup = System.in;
    administrator = new Administrator();
    
    Playground abcd = new Playground();
    String input = "sp";
    //String status = "available";
    //String beggining = "12";
    //String end = "14";
    //String price = "1";
    
    InputStream in = new ByteArrayInputStream(input.getBytes());
    
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    abcd.setLocation();
    System.setIn(in);
    
    input = "available";
    in = new ByteArrayInputStream(input.getBytes());
    abcd.setStatus();
    System.setIn(in);

    
    abcd.setCancellationPeriod(2);
    input = "12";
    in = new ByteArrayInputStream(input.getBytes());
    abcd.setBooking();
    System.setIn(in);
    
    input = "14";
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    input = "1";
    in = new ByteArrayInputStream(input.getBytes());
    abcd.setPrice();
    System.setIn(in);
    
    System.setIn(sysInBackup);
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    InputStream sysInBackup = System.in;
    int res = administrator.bookByName("bolo","jose",100);
    String input = "12";
    //String lon = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    
    input = "1";
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    input = "12";
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    
    System.setIn(sysInBackup);
    assertEquals(1,res);
  }
}
