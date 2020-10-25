import java.util.ArrayList;

public class Level {
    private ArrayList<Task> tasks;

    public Level(){
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(String name, String instructions, int numActions, int[] rewards){
        Task temp = new Task(name, instructions, numActions, rewards);
        tasks.add(temp);
    }

    public boolean isFinished(){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).isFinished() == false){
                return false;
            }
        }
        return true;
    }
}
