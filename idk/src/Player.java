import java.util.Arrays;

public class Player {
    private int xPos;
    private int yPos;
    private int[] attArr; //Maybe change this later from int[] to Attribute[]
    private int[] status;

    public String[] attributeTitles = {"Health", "Hygiene", "Intelligence", "Strength", "SocialStanding"};

    public Player(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.attArr = new int[]{1,1,1,1,1};
    }

    public int getX(){
        return this.xPos;
    }

    public int getY(){
        return this.yPos;
    }

    public void setX(int x) {xPos = x;}

    public void setY(int y) {yPos = y;}

    //Where attribute format is [Health, Hygiene, Intelligence, Strength, SocialStanding]
    public int getAttributeVal(String attName){
        int indexInAtt = Arrays.asList(attributeTitles).indexOf(attName);
        return attArr[indexInAtt];
    }

    public void setAttributeVal(String attName, int attVal){
        int indexInAtt = Arrays.asList(attributeTitles).indexOf(attName);
        attArr[indexInAtt] = attVal;
    }

    public int[] getAttributes(){
        return attArr;
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
            default:
                break;
        }
    }

    public int[] getStatus(){
        String goodStatus = "Positive Statuses: ";
        String badStatus = "Negative Statuses: ";
        for (int statusVal : status) {
            if (statusVal == 0) {
                goodStatus += ""; //Will add the actual status name
            } else
                badStatus += ""; //Will add the actual status name
        }
        //Output the two lists so that they can be more easily readable
        return status;
    }

    public void setStatus(int[] status){
        this.status = status;
    }

    /*
    public boolean isEnterableRoom(){

    }
     */
}
