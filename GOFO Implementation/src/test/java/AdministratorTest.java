package codigo.src;
import System.Administrator;
import System.Playground;
import System.PlayGroundSchedule;
import java.io.InputStream;
import org.mockito.Mockito.*;
import java.io.IOException;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  Administrator test = mock(Administrator.class);

  @Before
  public void setUp(){
    Administrator.IntegerAsker asker = mock(Administrator.IntegerAsker.class);
    administrator = new Administrator();
    Playground abcd = new Playground();
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    abcd.setLocation();
    try{
      when(asker.ask("Enter the playground Location:")).thenReturn("sp");
      abcd.setStatus();
      when(asker.ask("Enter the playground status:")).thenReturn("available");
      abcd.setCancellationPeriod(2);
      abcd.setBooking();
      when(asker.ask("Enter the beggining time of booking for your playground")).thenReturn("12");
      when(asker.ask("Enter the end time of booking for your playground")).thenReturn("14");
    }
    catch (IOException ioe) {
         System.out.println(ioe);
      }
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    Administrator.IntegerAsker asker = mock(Administrator.IntegerAsker.class);
    administrator.bookByName("bolo","jose",2);
    try{
      when(asker.ask("Enter the time you want to book in")).thenReturn("12");
      when(asker.ask("How many hours Do you want to book")).thenReturn("1");
      when(asker.ask("Enter the day you want to book in")).thenReturn("12");
    }
    catch (IOException ioe) {
         System.out.println(ioe);
      }
  }
}
