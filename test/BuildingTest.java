import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildingTest {

    @Test
    public void getXTest(){
        TaskManager manager =  new TaskManager();
        Person[] npcs = {};
        Building testBuild =  new Building(5, 6, manager, npcs);
        assertEquals(testBuild.getX(), 5);
    }

    @Test
    public void getYTest(){
        TaskManager manager =  new TaskManager();
        Person[] npcs = {};
        Building testBuild =  new Building(5, 6, manager, npcs);
        assertEquals(testBuild.getY(), 6);
    }

    @Test
    public void setPosTest(){
        TaskManager manager =  new TaskManager();
        Person[] npcs = {};
        Building testBuild =  new Building(5, 6, manager, npcs);
        testBuild.setPos(1, 2);
        assertEquals(testBuild.getX(), 1);
        assertEquals(testBuild.getY(), 2);
    }

    @Test
    public void getNpcsTest(){
        TaskManager manager =  new TaskManager();
        Person[] npcs = {new Person("Podgurski", "ACTIVE"), new Person("Dinhofer", "ACTIVE")};
        Building testBuild =  new Building(5, 6, manager, npcs);
        Person testPodgurski = testBuild.getNpcs()[0];
        assertEquals(testPodgurski.getName(), "Podgurski");
        assertEquals(testPodgurski.getStatus(), "ACTIVE");
    }

    @Test
    public void changeNpcTest(){
        TaskManager manager =  new TaskManager();
        Person[] npcs = {new Person("Podgurski", "ACTIVE"), new Person("Dinhofer", "ACTIVE")};
        Building testBuild =  new Building(5, 6, manager, npcs);
        testBuild.changeNpc("Dinhofer");
        Person testDinhofer = testBuild.getNpcs()[1];
        assertEquals(testDinhofer.getName(), "Dinhofer");
        assertEquals(testDinhofer.getStatus(), "DORMANT");
    }
}
