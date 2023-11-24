package codigo.src;
import System.userProfile;
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
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    u = new userProfile();
  }/*
  @Test
  public void getFullNameTest(){
    u.setFName("vovó");
    u.setLName("juju");
    assertEquals("vovó juju",u.getFullName());
  }*/
}
