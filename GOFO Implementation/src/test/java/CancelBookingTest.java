package codigo.src;
import System.PlaygroundOwner;
import System.Playground;
import System.Player;
import java.io.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CancelBookingTest{

  @Rule
  public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();
  @Before
  public void setUp(){
    Playground play = new Playground();
    play.setName("Teste");
    play.setOwner("Robinson");
    systemIn.provideLines("mg");
    play.setLocation();
    systemIn.provideLines("available");
    play.setStatus();
    play.setCancellationPeriod(2);
    systemIn.provideLines("1", "4");
    play.setBooking();
    systemIn.provideLines("1");
    play.setPrice();

    
  }
}
