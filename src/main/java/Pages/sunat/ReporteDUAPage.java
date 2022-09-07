package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class ReporteDUAPage {
    private WebDriver driver;
    private By numManifiestoText = By.xpath("(((//table)[4]//tr)[2]//td)[2]//b");
    private By viaTransporteText = By.xpath("(((//table)[4]//tr)[2]//td)[3]//b");
    private By numSerieSelect = By.xpath("//select[@onchange='makeLinkSerie(this);']");

    public ReporteDUAPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAnoManifiesto(){
        Browser.waitForElement(this.driver, numManifiestoText);
        return this.driver.findElement(numManifiestoText).getText().split("-")[0].trim();
    }

    public String getNumManifiesto(){
        Browser.waitForElement(this.driver, numManifiestoText);
        return this.driver.findElement(numManifiestoText).getText().split("-")[1].trim();
    }
    public String getViaTransporte(){
        Browser.waitForElement(this.driver, viaTransporteText);
        return this.driver.findElement(viaTransporteText).getText().split("-")[0].trim();
    }
    public DeclaracionSeriePage selectNumSerie(String numSerie){
        Browser.waitForElement(this.driver, numSerieSelect);
        findSelectElement(numSerieSelect).selectByValue(numSerie);
        return new DeclaracionSeriePage(Browser.getChildWindow(this.driver));
    }
    private Select findSelectElement(By identifier){
        return new Select(this.driver.findElement(identifier));
    }
}
