public class Task {
    private boolean[] actions;

    public Task(int numActions){
        actions = new boolean[numActions];
        for (int i = 0; i < numActions; i++){
            actions[i] = false;
        }
    }

    public void completeAction(int index){
        actions[index] = true;
    }

    public boolean isFinished(){
        for(int i = 0; i < actions.length; i++){
            if(actions[i] == false){
                return false;
            }
        }
        return true;
    }
}
