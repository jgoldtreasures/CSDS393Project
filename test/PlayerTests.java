import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTests {
    int xVal = 50;
    int yVal = 50;
    public Player p1 = new Player(xVal, yVal);

    @Test
    public void getPosTests(){
        assertEquals(p1.getX(),xVal);
        assertEquals(p1.getY(),yVal);
    }

    @Test
    public void setPosTests(){
        int newX = 60;
        int newY = 75;
        p1.setX(newX);
        p1.setY(newY);
        assertEquals(p1.getX(), newX);
        assertEquals(p1.getY(), newY);
    }

   /* @Test
    public void setStatusTest(){

    }

    /*
    @Test
    public void setYTest(){

    }
    */

}
