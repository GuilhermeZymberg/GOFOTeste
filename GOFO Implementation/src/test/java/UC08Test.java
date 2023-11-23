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

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UC08Test {
  private PlayGroundSchedule playGroundSchedule;
  private Playground playGround;
  private Administrator admin;
  private Player player, player2;
  private PlayerUI pui;
  private ArrayList<Player> Aplayer = new ArrayList<Player>();
  
  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
   
  @Before
  public void setUp() {
    Scanner input = new Scanner(System.in);
    player = new Player();
    player2 = new Player();
    Aplayer.add(player);
    Aplayer.add(player2);
    player.setEmail("pedro@gmail.com");
    playGroundSchedule = new PlayGroundSchedule("available", 2, 1, 3);
    playGround = new Playground("Playground1", "Pedro", "SBC", 2, 20, "available", playGroundSchedule);
    admin = new Administrator();
  }

  @Test
  public void criaTime(){
    System.out.println("UC08 ---------------------------------------------------------------------------------------------");
    systemIn.provideLines(4, 1);
    pui = new PlayerUI(input, 0, Aplayer, "Pedro", 40);
  }
}
