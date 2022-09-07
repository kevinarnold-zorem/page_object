package alerts;

import Pages.AlertsPage;
import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test
    public void testAcceptAlert(){
        AlertsPage alertsPage = this.homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Result text incorrect.");
    }

    @Test
    public void testGetTextFromAlert(){
        AlertsPage alertsPage = this.homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputAlert(){
        AlertsPage alertsPage = this.homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text incorrect");
    }
}
