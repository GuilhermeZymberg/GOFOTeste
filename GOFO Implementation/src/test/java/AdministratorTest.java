package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlayGroundSchedule;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.
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
    InputOutput inputOutput= new InputOutput();
    
    Playground abcd = new Playground();
    String location = "sp";
    String status = "available";
    String beggining = "12";
    String end = "14";
    
    InputStream loc = new ByteArrayInputStream(location.getBytes());
    InputStream stat = new ByteArrayInputStream(status.getBytes());
    InputStream beg = new ByteArrayInputStream(beggining.getBytes());
    InputStream en = new ByteArrayInputStream(end.getBytes());
    
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    abcd.setLocation();
    System.setIn(loc);
    abcd.setStatus();
    System.setIn(stat);
    abcd.setCancellationPeriod(2);
    abcd.setBooking();
    System.setIn(beg);
    System.setIn(en);
    System.setIn(sysInBackup);
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    InputStream sysInBackup = System.in;
    Administrator.IntegerAsker asker = Mockito.mock(Administrator.IntegerAsker.class);
    administrator.bookByName("bolo","jose",2);
    String tim = "12";
    String lon = "1";
    InputStream t = new ByteArrayInputStream(tim.getBytes());
    InputStream l = new ByteArrayInputStream(l.getBytes());
    
    System.setIn(i);
    System.setIn(l);
    System.setIn(t);
    System.setIn(sysInBackup);
  }
}
