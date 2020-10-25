import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class attributesTest {
    public static String attTitle = "Health";
    public static int attNum = 0;
    public static Attribute att1 = new Attribute(attTitle,attNum);

    @Test
    public void getAttNameTest(){
        assertEquals(att1.getAttName(),"Health");
    }

    @Test
    public void getAttValTest(){
        assertEquals(att1.getAttVal(), attNum);
    }

    @Test
    public void attEqualTest(){
        Attribute att2 = new Attribute(attTitle, attNum);
        assertTrue(att2.attributesEqual(att1));
    }

    @Test
    public void getAttTest(){
        Attribute att2 = att1.getAttribute();
        assertTrue(att2.attributesEqual(att1));
    }

    @Test
    public void createAttTest(){
        Attribute att2 = Attribute.createAttribute(attTitle,attNum);
        assertTrue(att2.attributesEqual(att1));
    }

    /*
    I used att3 because when using att1, it would make other tests
    fail, probably because its static?
     */
    @Test
    public void setAttributeTest() {
        Attribute att3 = Attribute.createAttribute(attTitle,attNum);
        att3.changeAttribute(2);
        assertEquals(att3.getAttVal(),2);
    }
}
