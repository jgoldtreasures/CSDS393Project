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

    @Test
    public void completionTest(){
        Game g = new Game();
        Level s = g.getSenior();
        ArrayList<Task> tasks = s.getTasks();
        tasks.get(0).completeAction(0);
        tasks.get(0).completeAction(1);
        tasks.get(1).completeAction(0);
        tasks.get(1).completeAction(1);
        tasks.get(1).completeAction(2);
        tasks.get(1).completeAction(3);
        tasks.get(1).completeAction(4);
        tasks.get(1).completeAction(5);
        assertTrue(g.gameFinished());

    }

    @Test
    public void testGetters(){
        Game g = new Game();
        Level Freshman = new Level();
        Freshman.addTask("Choose Roommate", "Go to the Freshman Dorms and choose one of the available roommates", 2, new int[]{1,0,0,0,0,0});
        Freshman.addTask("Take Campus Tour", "Visit every building on campus", 10, new int[]{0, 1, 0, 0, 0, 0});
        Level Sophomore = new Level();
        Sophomore.addTask("Declare Major", "Go to Nord Hall and fill out a declare major form", 2, new int[]{1,0,0,1,1,0});
        Sophomore.addTask("Join Club", "Go to Tinkham Veale University Center and join one of the available clubs", 2, new int[]{0,0,1,0,1,0});
        Level Junior = new Level();
        Junior.addTask("Pass test", "Go to the Bingham building, take the necessary test, and pass it", 3, new int[]{0,0,1,1,0,0,0});
        Junior.addTask("Study", "Go to the Kelvin Smith Library and study one of the books", 2, new int[]{0,0,0,1,1,0});
        assertEquals(g.getFreshman().getTasks().get(0).getName(), Freshman.getTasks().get(0).getName());
        assertEquals(g.getSophomore().getTasks().get(0).getName(), Sophomore.getTasks().get(0).getName());
        assertEquals(g.getJunior().getTasks().get(0).getName(), Junior.getTasks().get(0).getName());
    }


    @Test
    public void testDay(){
        Day d = new Day("Monday");
        d.useHours(5);
        assertEquals(d.whatDayIsIt(), "Monday");
        assertEquals(d.getHour(), 5);
    }
}