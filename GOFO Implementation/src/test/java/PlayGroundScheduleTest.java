package test.java;
import codigo.System.PlayGroundSchedule;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PlayGroundScheduleTest {

    private PlayGroundSchedule playGroundSchedule;

    @Before
    public void setUp() {
        playGroundSchedule = new PlayGroundSchedule();
    }
 
    @Test
    //teste para verificar a impressao com saldo suficiente
    public void testIndex() {
        assertEquals(1, playGroundSchedule.getDayIndex("sunday"));
    }
}
