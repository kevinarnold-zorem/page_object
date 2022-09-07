package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By btnRetrievePassword = By.id("form_submit");
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String email){
        this.driver.findElement(emailField).sendKeys(email);
    }
    public void clickRetrievePasswordButton(){
        this.driver.findElement(btnRetrievePassword).click();
    }
}
