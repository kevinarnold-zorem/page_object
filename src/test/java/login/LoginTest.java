package login;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfullLogin(){
        LoginPage loginPage = this.homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage sap = loginPage.clickLoginButton();

        assertTrue(sap.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");
    }

}
