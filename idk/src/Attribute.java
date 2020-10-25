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

    public static Attribute createAttribute(String name, int val){
        return new Attribute(name, val);
    }

    public void changeAttribute(int val){
        this.attVal += val;
    }

    /*The following method is just for the test file so that I can compare objects
        However, it shouldn't be used in the main file because each attribute name should be unique
     */
    public boolean attributesEqual(Attribute att2){
        boolean attsEquiv = false;
        if(this.getAttName().equals(att2.getAttName())) {
            if(this.getAttVal() == att2.getAttVal()){
                attsEquiv=true;
            }
        }
        return attsEquiv;
    }
}
