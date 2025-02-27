package codigo.src;
import System.PlayGroundSchedule;
import System.Administrator;
import System.Playground;
import System.Player;
import UI.PlayerUI;
import java.io.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UC06Test {

  private PlayGroundSchedule playGroundSchedule;
  private Playground playGround;
  private Administrator admin;
  private Player player;
  private PlayerUI pui;
  private ArrayList<Player> Aplayer = new ArrayList<Player>();
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  @Before
  public void setUp() {
    player = new Player();
    player.setEmail("pedro@gmail.com");
    playGroundSchedule = new PlayGroundSchedule("available", 2, 1, 3);
    playGround = new Playground("Playground1", "Pedro", "SBC", 2, 20, "available", playGroundSchedule);
    admin = new Administrator();
    admin.playgroundRequests(playGround);
    systemIn.provideLines("yes");
    admin.approvePlayground();

    pui = new PlayerUI();
  }

  @Test
  public void TesteUC06(){
    exit.expectSystemExitWithStatus(0);
    Scanner input = new Scanner(System.in);
    System.out.println("UC06 =============");
    systemIn.provideLines("11", "SBC", "12", "3");
    pui.playerMenu(input, 0, Aplayer, "Pedro", 45);
  }
}
