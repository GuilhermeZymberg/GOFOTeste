package codigo.src;
import UI.SystemUI;
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

public class UC05Exception02Test {

  private SystemUI s;
  
  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();
  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

  @Before
  public void setUp() {
    s = new SystemUI();
  }

  @Test
  public void TesteUC05(){
    exit.expectSystemExitWithStatus(0);
     systemIn.provideLines("2","gui","z", "7","1234", "gui@gm.com","11", "sp","playground owner","50","bolinha","1","gui@gm.com","1234","1","cetobarrero","gg","4","available","1","4","10","8","1","admin@gmail.com","123","1","yes","6","2","gu","z", "7","1234", "gu@gm.com","11", "sp","player","1","bolinha","1","gu@gm.com","1234","3","2","cetobarrero","1","2","saturday","12","3");
    s.accountMenu();
  }
}
