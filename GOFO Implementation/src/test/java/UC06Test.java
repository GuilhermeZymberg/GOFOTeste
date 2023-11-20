package codigo.src;
import System.Administrator;
import System.Playground;
import UI.PlayerUI;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UC06Test {

  private Playground playGround;
  private Administrator admin;
  private PlayerUI player;
  
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

  @Before
  public void setUp() {
    admin = new Administrator();
    player = new PlayerUI();
    playGround = new Playground("Playground1", "Pedro", "SBC", 2, 20, "available", playGroundSchedule);
  }

  @Test
  public void Teste(){
    admin.searchByName("Playground1");
  }
}
