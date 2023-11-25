package codigo.src;
import System.PlayGroundSchedule;
import System.PlaygroundOwner;
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

public class PlayGroundScheduleTest {

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    private PlayGroundSchedule playGroundSchedule;
    private PlayGroundSchedule playGroundSchedule2;
    private PlayGroundSchedule playGroundSchedule3;
    private PlaygroundOwner playGroundOwner;
    private Playground playGround;
    private Playground playGround2;
    private Administrator admin;
    private Player player;

    @Before
    public void setUp() {
        playGroundSchedule = new PlayGroundSchedule("available", 2, 1, 3);
        playGroundSchedule2 = new PlayGroundSchedule("not available", 2, 2, 4);
        playGroundOwner = new PlaygroundOwner();
        playGround = new Playground("Playground1", "Pedro", "SBC", 2, 20, "available", playGroundSchedule);
        playGround2 = new Playground("Playground2", "Pedro", "SP", 2, 20, "available", playGroundSchedule);
        admin = new Administrator();
        player = new Player();
        playGroundOwner.addPlayground(playGround);        
    }
    
    /* PLAYGROUND */

    /* GET */
    @Test
    public void testGetCancel(){
        assertEquals(2, playGround.getCancellationPeriod());
    }
    @Test
    public void testGetName(){
        assertEquals("Playground1", playGround.getName());
    }
    @Test
    public void testGetStatus(){
        assertEquals("available", playGround.getStatus());
    }
    @Test
    public void testGetLocation(){
        assertEquals("SBC", playGround.getLocation());
    }
    @Test
    public void testGetPrice(){
        assertEquals(20, playGround.getPrice());
    }
    @Test
    public void testGetBegin(){
        assertEquals(1, playGround.getSlotsBegin());
    }
    @Test
    public void testGetEnd(){
        assertEquals(3, playGround.getSlotsEnd());
    }
    @Test
    public void testGetOwner(){
        assertEquals("Pedro", playGround.getOwner());
    }

    /* SET */
    @Test
    public void testSetOwner(){
        playGround.setOwner("Jonas");
        assertEquals("Jonas", playGround.getOwner());
    }
    @Test
    public void testSetName(){
        playGround.setName("Jonas");
        assertEquals("Jonas", playGround.getName());
    }
    @Test
    public void testSetCancel(){
        playGround.setCancellationPeriod(3);
        assertEquals(3, playGround.getCancellationPeriod());
    }
    @Test
    public void testSetPlace(){
        systemIn.provideLines("SP");
        playGround.setLocation();
        assertEquals("SP", playGround.getLocation());
    }
    @Test
    public void testSetPrice(){
        systemIn.provideLines("40");
        playGround.setPrice();
        assertEquals(40, playGround.getPrice());
    }
    @Test
    public void testSetStatus(){
        systemIn.provideLines("not available");
        playGround.setStatus();
        assertEquals("not available", playGround.getStatus());
    }
    @Test
    public void testSetSchedule(){
        playGround.setSchedule(playGroundSchedule2);
        assertEquals(2, playGround.getSlotsBegin());
        assertEquals(4, playGround.getSlotsEnd());
    }
    

    /* BOOKING */
    /*
    @Test
    public void testBooking(){
        playGround.bookingTheSlot("Pedro", "2", "sunday");
    }
    @Test
    public void testFree(){
        playGround.freeSlots();
    }
    @Test
    public void testSetBooking(){
        systemIn.provideLines("2", "4");
        playGround.setBooking();
        assertEquals(40, playGround.getPrice());
    }*/

    /* PLAYGROUD OWNER*/
    
    @Test
    public void testPlayExist(){
        assertEquals(true, playGroundOwner.existPlayground("Playground1"));
    }
    @Test
    public void testPlayNotExist(){
        assertEquals(false, playGroundOwner.existPlayground("Playground14"));
    }
    @Test
    public void testReciveMsg(){
        playGroundOwner.addRecieveMsg("Oi");
        playGroundOwner.displayRecieveMsg();
    }
    @Test
    public void testAddPlayground(){
        playGroundOwner.getListofPlayground();
        playGroundOwner.addPlayground(playGround2);
        playGroundOwner.getListofPlayground();
        systemIn.provideLines("1", "PlaygroundZe");
        playGroundOwner.updatePlaygroundName("Playground1");
    }

    /* PLAYGROUND SCHEDULE */
 
    @Test
    public void testIndex() {
        assertEquals(2, playGroundSchedule.getDayIndex("monday"));
    }
    @Test
    public void TestSetPrice(){
        assertEquals(2, playGroundSchedule.getTimeSlotPerHour());
    }
    @Test
    public void Testbegin(){
        assertEquals(1, playGroundSchedule.getBegin());
    }
    @Test
    public void TestEnd(){
        assertEquals(3, playGroundSchedule.getEnd());
    }
    @Test
    public void test(){
        playGroundSchedule3 = new PlayGroundSchedule();
        systemIn.provideLines("4", "5");
        playGroundSchedule3.setschedule();
        playGroundSchedule3.displayFreeSlots();
        playGroundSchedule3.displayAllSlots();
    }
}
