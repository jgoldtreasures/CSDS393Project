public class Attribute {
    private int attVal;
    private String attName;

    public Attribute(String attName, int attVal){
        this.attVal = attVal;
        this.attName = attName;
    }

    public int getAttVal() {
        return attVal;
    }

    public String getAttName() {
        return attName;
    }

    public Attribute getAttribute(){
        return new Attribute(getAttName(),getAttVal());
    }

    public void createAttribute(String name, int val){
        new Attribute(name, val);
    }

    public void changeAttribute(int val){
        this.attVal += val;
    }
}
