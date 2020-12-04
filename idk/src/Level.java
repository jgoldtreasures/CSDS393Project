import java.util.ArrayList;

public class Level {
    private ArrayList<Task> tasks;
    private boolean finish;
    private String name;

    public Level(String name){
        this.tasks = new ArrayList<Task>();
        finish = false;
        this.name = name;
    }

    public void addTask(String name, String instructions, int numActions, int[] rewards){
        Task temp = new Task(name, instructions, numActions, rewards);
        tasks.add(temp);
    }

    public boolean isFinished(){
        if(finish){
            return true;
        }
        else {
            for (Task task : tasks) {
                if (!task.isFinished()) {
                    return false;
                }
            }
            finish = true;
            return true;
        }
    }

    public ArrayList<Task> getTasks(){return tasks;}

    public void setFinish(){
        finish = true;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){this.name = newName;}
}
