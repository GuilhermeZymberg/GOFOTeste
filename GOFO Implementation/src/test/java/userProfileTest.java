package codigo.src;
import System.userProfile;
import System.eWallet;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class userProfileTest{
  
  private userProfile u;
  private eWallet e;
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    u = new userProfile();
    e = new eWallet();
  }
  @Test
  public void getFullNameTest(){
    System.out.println("----TESTE SET FNAME, SET LNAME E GET FULL NAME----");
    u.setFName("vovó");
    u.setLName("juju");
    assertEquals("vovó juju",u.getFullName());
    System.out.println("----FIM----");
  }
  @Test
  public void setPaymentTest(){
    System.out.println("----SET PAYMENT----");
    u.setPayment(e);
    System.out.println("----FIM----");
  }
  @Test 
  public void getIDTest(){
    System.out.println("----TESTE SET E GET ID----");
    u.setID(2);
    assertEquals(2,u.getID());
    System.out.println("----FIM----");
  }
  @Test 
  public void getPasswordTest(){
    System.out.println("----TESTE SET E GET PASSWORD----");
    u.setPassword("42");
    assertEquals("42",u.getPassword());
    System.out.println("----FIM----");
  }
  @Test 
  public void getPhoneTest(){
    System.out.println("----TESTE SET E GET PHONE----");
    u.setPhone(5);
    assertEquals(5,u.getPhone());
    System.out.println("----FIM----");
  }
  @Test 
  public void getRuleTest(){
    System.out.println("----TESTE SET E GET RULE----");
    u.setRule("player");
    assertEquals("player",u.getRule());
    System.out.println("----FIM----");
  }
  @Test 
  public void setLocationTest(){
    System.out.println("----TESTE SET LOCATION----");
    u.setLocation("sp");
    System.out.println("----FIM----");
  }
}
