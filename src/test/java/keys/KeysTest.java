package keys;

import Pages.KeyPressesPage;
import base.BaseTest;
import org.openqa.selenium.Keys;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class KeysTest extends BaseTest {
    @Test
    public void testBackspace(){
        KeyPressesPage keysPage = this.homePage.clickPresses();
        keysPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keysPage.getResult(), "You entered: BACK_SPACE", "");
    }
    @Test
    public void testAtSymbol(){
        KeyPressesPage keysPage = this.homePage.clickPresses();
        keysPage.enterAt();

    }
}
