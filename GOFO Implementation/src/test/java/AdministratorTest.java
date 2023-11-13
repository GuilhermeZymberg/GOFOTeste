package codigo.src;
import System.Administrator;
import System.Playground;
import java.io.BufferedWriter;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  private Administrator administrator;

  @Before
  public void setUp(){
    administrator = new Administrator();
    Playground abcd = new Playground();
    abcd.setName("bolo");
    abcd.setOwner("Jonas");
    abcd.
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
  @Test
  public void testBookByName(){
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
    bookByName("bolo","jose",2);
    bw.write("teste");
    bw.newLine();
    bw.flush();
    bw.write("12");
    bw.newLine();
    bw.flush();
    bw.write("12");
    bw.newLine();
    bw.flush();
  }
}
