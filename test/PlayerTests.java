import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTests {
    static int xVal = 50;
    static int yVal = 50;
    public static Player p1 = new Player(xVal, yVal);

    @Test
    public void getXTest(){
        assertEquals(p1.getX(),xVal);
    }

    @Test
    public void getYTest(){
        assertEquals(p1.getY(),yVal);
    }
}
