package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // private By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        // this.driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(this.driver);
    }

    public DropDownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropDownPage(this.driver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(this.driver);
    }
    public ForgotPasswordPage clickForgotPassword(){
        clickLink("Forgot Password");
        return new ForgotPasswordPage(this.driver);
    }

    public KeyPressesPage clickPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(this.driver);
    }

    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(this.driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(this.driver);
    }

    public ModalPage clickModal(){
        clickLink("Entry Ad");
        return new ModalPage(this.driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    private void clickLink(String linkText){
        this.driver.findElement(By.linkText(linkText)).click();
    }
}
