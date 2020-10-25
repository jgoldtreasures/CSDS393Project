public class Person { //npc class
    String name;
    String status;

    //need npc to have setStatus method
    public Person(String name, String status){
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
