import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class gameTest {

    @Test
    public void taskTest(){
        Task exercise = new Task("Exercise", "Go to Veale Gym and use one of the machines", 2, new int[]{0,0,0,1,0,0});
        assertEquals(exercise.getName(), "Exercise");
        assertEquals(exercise.getInstructions(), "Go to Veale Gym and use one of the machines");
    }
}