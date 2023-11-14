package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlayGroundSchedule;
import java.io.InputStream;
import org.mockito.Mockito;
import java.io.IOException;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  Administrator test = Mockito.mock(Administrator.class);

  @Before
  public void setUp(){
    Administrator.IntegerAsker asker = Mockito.mock(Administrator.IntegerAsker.class);
    Playground abcd = new Playground();
    String loc = "sp";
    String status = "available";
    String beg = "12";
    String en = "14";
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    abcd.setLocation();
    try{
      Mockito.when(asker.ask("Enter the playground Location:")).thenReturn(loc);
      abcd.setStatus();
      Mockito.when(asker.ask("Enter the playground status:")).thenReturn(status);
      abcd.setCancellationPeriod(2);
      abcd.setBooking();
      Mockito.when(asker.ask("Enter the beggining time of booking for your playground")).thenReturn(beg);
      Mockito.when(asker.ask("Enter the end time of booking for your playground")).thenReturn(en);
    }
    catch (IOException ioe) {
         System.out.println(ioe);
      }
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",test.getPassword());
  }
  @Test
  public void testBookByName(){
    Administrator.IntegerAsker asker = Mockito.mock(Administrator.IntegerAsker.class);
    test.bookByName("bolo","jose",2);
    try{
      String tim = "12";
      String lon = "1";
      Mockito.when(asker.ask("Enter the time you want to book in")).thenReturn(tim);
      Mockito.when(asker.ask("How many hours Do you want to book")).thenReturn(lon);
      Mockito.when(asker.ask("Enter the day you want to book in")).thenReturn(tim);
    }
    catch (IOException ioe) {
         System.out.println(ioe);
      }
  }
}
