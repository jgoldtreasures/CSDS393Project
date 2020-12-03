public class Day{
    private int hour;
    private String DOW;

    public Day(String dow){
        hour = -1;
        DOW = dow;
    }

    public void useHours(int time){
        hour += time;
    }

    public String whatDayIsIt(){
        return DOW;
    }

    public int getHour(){
        return hour;
    }
}