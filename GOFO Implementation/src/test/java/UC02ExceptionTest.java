package codigo.src;
import System.PlayGroundSchedule;
import System.Administrator;
import System.Playground;
import System.Player;
import UI.PlayerUI;
import java.io.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UC02ExceptionTest {

  private PlayGroundSchedule playGroundSchedule;
  private Playground playGround;
  private Administrator admin;
  private Player player;
  private PlayerUI pui;
  private ArrayList<Player> Aplayer = new ArrayList<Player>();
  
  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
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
