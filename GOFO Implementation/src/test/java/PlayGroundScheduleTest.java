package codigo.src;
import System.PlayGroundSchedule;
import System.PlaygroundOwner;
import System.Playground;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PlayGroundScheduleTest {

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    private PlayGroundSchedule playGroundSchedule;
    private PlaygroundOwner playGroundOwner;
    private Playground playGround;

    @Before
    public void setUp() {
        playGroundSchedule = new PlayGroundSchedule("available", 2, 1, 3);
        playGroundOwner = new PlaygroundOwner();
        playGround = new Playground("Playground1", "Pedro", "SBC", 2, 20, "available", playGroundSchedule);
        playGroundOwner.addPlayground(playGround);
        systemIn.provideLines("45");
        playGroundSchedule.setPrice();
        
    }/*
    @Test
    public void testPlayExist(){
        assertEquals(true, playGroundOwner.existPlayground("Playground1"));
    }
    
    @Test
    public void testPlayNotExist(){
        assertEquals(false, playGroundOwner.existPlayground("Playground14"));
    }
 
    @Test
    //teste para verificar a impressao com saldo suficiente
    public void testIndex() {
        assertEquals(2, playGroundSchedule.getDayIndex("monday"));
    }

    @Test
    public void TestSetPrice(){
        assertEquals(45, playGroundSchedule.getTimeSlotPerHour());
    }

    @Test
    public void Testbegin(){
        assertEquals(1, playGroundSchedule.getBegin());
    }

    @Test
    public void TestEnd(){
        assertEquals(3, playGroundSchedule.getEnd());
    }*/
}
