import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class screenTest {
    @Test
    public void screenDescTest(){
        ScreenDescriptions newScreen = new ScreenDescriptions("Bingham");
        assertEquals("Sleep",newScreen.returnDesc());
    }
}
