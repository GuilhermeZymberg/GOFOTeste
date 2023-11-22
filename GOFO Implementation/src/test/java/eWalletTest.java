package codigo.src;
import System.eWallet;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class eWalletTest{
  
  private eWallet e;
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    e = new eWallet();
    e.setBalance(100);
  }
  @Test
  public void setBalanceTest(){
    systemIn.provideLines("200");
    e.setBalance();
    assertEquals(200,e.getBalance());
  }
  @Test
  public void depositWithdrawTest(){
    e.setBalance(2);
    e.deposit(50);
    e.withdraw(42);
    assertEquals(10,e.getBalance());
  }
}
