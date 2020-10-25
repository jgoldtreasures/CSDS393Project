import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class gameTest {

    @Test
    public void taskTest(){
        int[] exRewards = new int[]{0,0,0,1,0,0};
        Task exercise = new Task("Exercise", "Go to Veale Gym and use one of the machines", 2, exRewards);
        assertEquals(exercise.getName(), "Exercise");
        assertEquals(exercise.getInstructions(), "Go to Veale Gym and use one of the machines");
        assertEquals(exercise.getRewards(), exRewards);
    }

    @Test
    public void levelTest(){
        Level test = new Level();
        test.addTask("T1", "test",2, new int[]{1,1,0,0,0,0});
        ArrayList<Task> tasks = test.getTasks();
        tasks.get(0).completeAction(0);
        tasks.get(0).completeAction(1);
        assertTrue(test.isFinished());
    }
}