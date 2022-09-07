package wait;

import Pages.DynamicLoadingExample1Page;
import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class WaitTests extends BaseTest {
    @Test
    public void testWaitUntilHidden(){
        DynamicLoadingExample1Page loadingPage = this.homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }
}
