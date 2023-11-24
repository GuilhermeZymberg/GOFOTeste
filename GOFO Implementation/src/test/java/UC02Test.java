package codigo.src;
import System.userProfile;
import UI.playgroundOwnerUI;
import System.Playground;
import System.PlaygroundOwner;
import System.eWallet;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

public class UC02Test{
  private PlaygroundOwner pg1;
  private PlaygroundOwner pg2;
  private playgroundOwnerUI pu;
  private Playground p;
  private eWallet e1;
  private eWallet e2;
  static ArrayList<PlaygroundOwner> pgs;
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    e1 = new eWallet();
    e2 = new eWallet();
    pg1 =  new PlaygroundOwner();
    pg2 = new PlaygroundOwner();
    pu = new playgroundOwnerUI();
    pgs = new ArrayList<PlaygroundOwner>();
    p = new Playground();
  }/*
  @Test
  public void addPlaygroundTest(){
    System.out.println("----UC02 - PLAYGROUND REGISTRATION TEST----");
    System.out.println("--Main Flow--");

    //p setup 
    p.setName("Bão");
    systemIn.provideLines("sp");
    p.setLocation();
    systemIn.provideLines("available");
    p.setStatus();
    p.setCancellationPeriod(2);
    systemIn.provideLines("1", "4");
    p.setBooking();
    systemIn.provideLines("1");
    p.setPrice();
    //pg1 setup - sem playground
    systemIn.provideLines("50");
    e1.setBalance();
    pg1.setBalance(e1);
    pg1.setFName("jo");
    pg1.setLName("jo");
    pg1.setPassword("1234");
    pg1.setID(2);
    pg1.setRule("playground owner");
    pg1.setPhone(42);
    pg1.setEmail("jojo@gml.com");
    pg1.setLocation("sp");

    //pg2 setup - com playground
    systemIn.provideLines("50");
    e2.setBalance();
    pg2.setBalance(e2);
    pg2.setFName("dio");
    pg2.setLName("dio");
    pg2.setPassword("5678");
    pg2.setID(1);
    pg2.setRule("playground owner");
    pg2.setPhone(33);
    pg2.setEmail("dio@gml.com");
    pg2.setLocation("eg");
    p.setOwner(pg2.getEmail());
    pg2.addPlayground(p);

    pgs.add(pg1);
    pgs.add(pg2);
    systemIn.provideLines("ceto barrero","gg","4","available","4","3","10");
    Scanner input = new Scanner(System.in);
    pu.addPlayground(input,pgs,"jojo@gml.com");
    assertTrue(pgs.get(0).existPlayground("ceto barrero"));
  }
  */
}
