package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By btnLogin = By.cssSelector("#login button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        this.driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        this.driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        this.driver.findElement(btnLogin).click();
        return new SecureAreaPage(this.driver);
    }
}
