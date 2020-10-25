import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class attributesTest {


    @Test
    public void getAttNameTest(){
        Attribute att1 = new Attribute("Health",0);
        assertEquals(att1.getAttName(),"Health");
    }
}
