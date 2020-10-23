public class Level {
    private ArrayList(Task) tasks;

    public Level(){
        tasks = new ArrayList(Task);
    }

    public void addTask(int numActions){
        tasks.add(new Task(numActions));
    }

    public boolean isFinished(){
        for(int i = 0; i < actions.length; i++){
            if(actions[i].isFinished() == false){
                return false;
            }
        }
        return true;
    }
}
