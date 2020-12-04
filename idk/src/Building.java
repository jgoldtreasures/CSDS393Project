import java.util.Arrays;
import java.util.List;

public class Building {
    private int x;
    private int y;
    private TaskManager tasks;
    private Person[] npcs;
    private String buildingName;

    public Building(int x, int y, TaskManager tasks, Person[] npcs) {
        this.x = x;
        this.y = y;
        this.tasks = tasks;
        this.npcs = npcs;
    }

    public Building(int x, int y, String buildingName) {
        this.x = x;
        this.y = y;
        this.buildingName = buildingName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName(){return buildingName;}

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public TaskManager getTasks() {
        return this.tasks;
    }

    public boolean hasTask(){
        return this.tasks != null;
    }

//    public void removeTask(String task) {
//        List<Task> taskList = Arrays.asList(tasks.getTasks());
//        taskList.removeIf(task1 -> task1.getName() == task);
//        tasks = new TaskManager(taskList);      //need task manager constructor to take list of tasks as argument
//    }

    public Person[] getNpcs() {
        return this.npcs;
    }

    public Boolean changeNpc(String name) {
        List<Person> npcList = Arrays.asList(npcs);
        boolean changed = false;
        for (Person npc : npcList) {
            if (npc.getName().equals(name)) {
                npc.setStatus("DORMANT");      //need npc to have setStatus method
                changed = true;
            }
        }
        return changed;
    }
}
