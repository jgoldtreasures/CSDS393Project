import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {
    int xVal = 50;
    int yVal = 50;
    int[] state = {0,0,0};
    int[] attValues = {0,0,0,0,0};
    public Player p1 = new Player(xVal, yVal, state, attValues);

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

   @Test
    public void setStatusTest(){
        int[] status = {0,0,0};
        int[] goalStatus = {0,0,0};

        p1.setPlayerStatus("yolo");
        assertArrayEquals(p1.getStatus(), goalStatus);

        p1.setPlayerStatus("Tired");
        goalStatus[0]=1;
        assertArrayEquals(p1.getStatus(),goalStatus);
        p1.setPlayerStatus("Awake");
        goalStatus[0]=0;
        assertArrayEquals(p1.getStatus(),goalStatus);

        p1.setPlayerStatus("Sick");
        goalStatus[1]=1;
        assertArrayEquals(p1.getStatus(),goalStatus);
        p1.setPlayerStatus("Healthy");
        goalStatus[1]=0;
        assertArrayEquals(p1.getStatus(),goalStatus);

        p1.setPlayerStatus("Dirty");
        goalStatus[2]=1;
        assertArrayEquals(p1.getStatus(),goalStatus);
        p1.setPlayerStatus("Clean");
        goalStatus[2]=0;
        assertArrayEquals(p1.getStatus(),goalStatus);
    }

    @Test
    public void attValueGetTest(){
        int healthVal = p1.getAttributeVal("Health");
        assertEquals(healthVal, 0);
    }

}
