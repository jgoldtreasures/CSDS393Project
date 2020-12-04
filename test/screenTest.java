import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class screenTest {
    @Test
    public void screenDescTest(){
        ScreenDescriptions newScreen = new ScreenDescriptions("Bingham");
        assertEquals("Contains the civil and environmental engineering offices, lecture" +
                " halls, and sleeping/studying spaces",newScreen.returnDesc());
    }
}
