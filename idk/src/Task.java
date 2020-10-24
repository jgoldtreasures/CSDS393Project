public class Task {
    private boolean[] actions;
    private int[] rewards;
    private String name;
    private String instructions;

    public Task(String name, String instructions, int numActions, int[] rewards){
        this.name = name;
        this.instructions = instructions;
        actions = new boolean[numActions];
        for (int i = 0; i < numActions; i++){
            actions[i] = false;
        }
        this.rewards = rewards;
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

    public int[] getRewards(){
        return rewards;
    }


}
