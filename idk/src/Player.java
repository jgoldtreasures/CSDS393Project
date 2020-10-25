public class Player {
    private int xPos;
    private int yPos;
    private Attribute[] attList;
    private int[] status;

    public Player(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;

    }

    public int getX(){
        return this.xPos;
    }

    public int getY(){
        return this.yPos;
    }

    //Where attribute format is [Health, Hygiene, Intelligence, Strength, SocialStanding]
    public int getAttributeVal(String attName){
        return 5;
    }

    // Where status format is [Tired, Sick, Dirty]
    //Maybe change this to be tuple formatted
    public void setPlayerStatus(String newStatus){
        switch(newStatus){
            case "Awake":
                status[0] = 0;
                break;
            case "Tired":
                status[0] = 1;
                break;
            case "Sick":
                status[1] = 1;
                break;
            case "Healthy":
                status[1] = 0;
                break;
            case "Dirty":
                status[2] = 1;
                break;
            case "Clean":
                status[2] = 0;
                break;
        }
    }

    public int[] getStatus(){
        String goodStatus = "Positive Statuses: ";
        String badStatus = "Negative Statuses: ";
        for(int i=0; i<status.length; i++){
            if(status[i]==0){
                goodStatus += ""; //Will add the actual status name
            }
            else
                badStatus += ""; //Will add the actual status name
        }
        //Output the two lists so that they can be more easily readable
        return status;
    }

    /*
    public boolean isEnterableRoom(){

    }
     */
}
