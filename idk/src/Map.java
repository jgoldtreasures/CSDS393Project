import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private Building[] buildings;

    public Map(Building[] buildings){
        this.buildings = buildings;
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public void enterBuilding(){

    }

    public void addBuilding(Building building){
        List<Building> buildingList = Arrays.asList(buildings);
        ArrayList<Building> buildingArrayList = new ArrayList<>(buildingList);
        buildingArrayList.add(building);
        buildings = buildingArrayList.toArray(new Building[0]);
    }
}
