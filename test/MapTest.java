import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapTest {

    @Test
    public void getBuildingsTest(){
        TaskManager manager =  new TaskManager();
        Person[] npcs = {new Person("Podgurski", "ACTIVE"), new Person("Dinhofer", "ACTIVE")};
        Building testBuild1 =  new Building(5, 6, manager, npcs);
        Building testBuild2 =  new Building(5, 6, manager, npcs);
        Building[] builds = {testBuild1, testBuild2};
        Map map = new Map(builds);
        Person testPodgurski = map.getBuildings()[0].getNpcs()[0];
        assertEquals(testPodgurski.getName(), "Podgurski");
        assertEquals(testPodgurski.getStatus(), "ACTIVE");
    }

    @Test
    public void addBuildingsTest(){
        TaskManager manager =  new TaskManager();
        Person[] npcs = {new Person("Podgurski", "ACTIVE"), new Person("Dinhofer", "ACTIVE")};
        Building testBuild1 =  new Building(5, 6, manager, npcs);
        Building testBuild2 =  new Building(5, 6, manager, npcs);
        Building[] builds = {testBuild1};
        Map map = new Map(builds);
        map.addBuilding(testBuild2);
        Person testDinhofer = map.getBuildings()[1].getNpcs()[1];
        assertEquals(testDinhofer.getName(), "Dinhofer");
        assertEquals(testDinhofer.getStatus(), "ACTIVE");
    }
}
