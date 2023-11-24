package codigo.src;

import System.userProfile;
import UI.SystemUI;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

public class UC02ExceptionTest{
  private SystemUI s;
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();
  @Test
  public void addPlaygroundTest(){
    exit.expectSystemExitWithStatus(0);
    systemIn.provideLines("2","gui","z", "7","1234", "gui@gm.com","11", "sp","player","50","bolinha","3","1","gui@gm.com","11","gg","4","available","4","3","10","3");
    s.accountMenu();
  }
/*
  @Before
  public void setUp(){
    e1 = new eWallet();
    e2 = new eWallet();
    pg1 =  new PlaygroundOwner();
    pg2 = new PlaygroundOwner();
    pu = new playgroundOwnerUI();
    pgs = new ArrayList<PlaygroundOwner>();
    p = new Playground();
  }*/
}
