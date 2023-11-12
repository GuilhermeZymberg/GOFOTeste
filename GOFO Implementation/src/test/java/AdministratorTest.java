package java;
import System.Administrator;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdministratorTest{
  
  private Administrator administrator;

  @Before
  public void setUp(){
    administrator = new Administrator();
  }
  @Test
  public void testGetPassword(){
    assertEquals("123",administrator.getPassword());
  }
}
