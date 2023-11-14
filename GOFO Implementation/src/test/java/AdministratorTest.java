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
    InputStream in = new ByteArrayInputStream(input.getBytes());
    abcd.setStatus();
    System.setIn(stat);

    
    abcd.setCancellationPeriod(2);
    input = "12";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    abcd.setBooking();
    System.setIn(beg);
    
    input = "14";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(en);

    input = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    abcd.setPrice();
    System.setIn(pr);
    
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
    System.setIn(t);
    
    input = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(l);

    input = "12";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(t);
    
    System.setIn(sysInBackup);
    assertEquals(1,res);
  }
}
