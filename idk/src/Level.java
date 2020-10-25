public class Level {
    private ArrayList(Task) tasks;

    public Level(){
        tasks = new ArrayList(Task);
    }

    public void addTask(int numActions){
        Task temp = new Task(name, instructions, numActions, rewards);
        tasks.add(temp);
    }

    public boolean isFinished(){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks[i].isFinished() == false){
                return false;
            }
        }
        return true;
    }
}
