package forgotpassword;

import Pages.ForgotPasswordPage;
import base.BaseTest;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    @Test
    public void testForgotPassword(){
        ForgotPasswordPage forgotPassword = this.homePage.clickForgotPassword();
        forgotPassword.setEmail("tau@gmail.com");
        forgotPassword.clickRetrievePasswordButton();
    }
}
