package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeclaracionSeriePage {
    private WebDriver driver;
    private By fobText = By.xpath("(((//table)[8]//tr)[2]//td)[2]//b");
    private By valorAduanaText = By.xpath("(((//table)[8]//tr)[2]//td)[6]//b");
    private By pesoNetoText = By.xpath("(((//table)[6]//tr)[2]//td)[3]//b");
    public DeclaracionSeriePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFob(){
        Browser.waitForElement(this.driver, fobText);
        return this.driver.findElement(fobText).getText();
    }
    public String getPesoNeto(){
        Browser.waitForElement(this.driver, valorAduanaText);
        return this.driver.findElement(pesoNetoText).getText();
    }
    public String getValorAduana(){
        Browser.waitForElement(this.driver, pesoNetoText);
        return this.driver.findElement(valorAduanaText).getText();
    }

    public void close(){
        this.driver.quit();
    }
}
