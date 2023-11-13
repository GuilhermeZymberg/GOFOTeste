package codigo.src;
import System.Administrator;
import System.Playground;
import java.io.*;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  private Administrator administrator;

  @Before
  public void setUp(){
    ProcessBuilder builder = new ProcessBuilder(command);
    final Process process = builder.start();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
    
    administrator = new Administrator();
    Playground abcd = new Playground();
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    abcd.setLocation();
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
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
    bookByName("bolo","jose",2);
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
}
