package hover;

import Pages.HoversPage;
import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverUser1(){
        HoversPage.FigureCaption fc = this.homePage.clickHovers().hoverOverFigure(1);
        assertTrue(fc.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(fc.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(fc.getLinkText(), "View profile", "Caption linkText incorrect");
        assertTrue(fc.getLink().endsWith("/users/1"), "Link incorrect");
    }
}
