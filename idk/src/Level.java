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
        if(finish == true){
            return true;
        }
        else {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).isFinished() == false) {
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
}
