package codigo.src;
import System.Administrator;
import System.Playground;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  private Administrator administrator;

  @Before
  public void setUp(){
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    administrator = new Administrator();
    Playground abcd = new Playground();
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    abcd.setLocation();
    try{
      bw.write("uber");
      bw.newLine();
      bw.flush();
      abcd.setStatus();
      bw.write("available");
      bw.newLine();
      bw.flush();
      abcd.setCancellationPeriod(2);
      abcd.setBooking();
      bw.write("12");
      bw.newLine();
      bw.flush();
      bw.write("14");
      bw.newLine();
      bw.flush();
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
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    administrator.bookByName("bolo","jose",2);
    try{
      bw.write("12"); //"time"
      bw.newLine();
      bw.flush();
      bw.write("12"); //hours
      bw.newLine();
      bw.flush();
      bw.write("12"); //days
      bw.newLine();
      bw.flush();
    }
    catch (IOException ioe) {
         System.out.println(ioe);
      }
  }
}
