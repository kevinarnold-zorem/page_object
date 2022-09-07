package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

public class ModalTest extends BaseTest {
    @Test
    public void testModal(){
        this.homePage.clickModal().clickCloseModalButton();
    }
}
