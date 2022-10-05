package tests.bbc1;


import tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class BBC1Part1Tests extends BaseTest {

    private static final int TITLES_ARRAY_LENGTH = 10;
    private static final String CATEGORY_TITLE = "Europe: Strangers on My Doorstep";

    @Test
    public void checkFirstAbstractTitle(){
        assertFalse(businessLogicLayer.isHeaderTextFromFirstAbstractEmpty());
    }

    @Test
    public void checkTitlesListPresence(){
        assertTrue(businessLogicLayer.getTitlesListElementsCount()>= TITLES_ARRAY_LENGTH);
    }

    @Test
    public void getCategoryText(){
        assertEquals(CATEGORY_TITLE, businessLogicLayer.checkSearchFieldFromNewsPage());
    }
}
