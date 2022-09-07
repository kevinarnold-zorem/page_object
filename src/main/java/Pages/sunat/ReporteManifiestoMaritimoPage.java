package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReporteManifiestoMaritimoPage {
    private WebDriver driver;

    public ReporteManifiestoMaritimoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConsignatario(String numConocimiento){
        String xpath = "(((//b[contains(text(), '"+numConocimiento+"')]/parent::*)/parent::*)/parent::tr//td)[12]";
        String x = "(((//b[contains(text(), 'CAP211429')]/parent::*)/parent::*)/parent::tr//td)[12]";
        return this.driver.findElement(By.xpath(xpath)).getText();
    }
    public void close(){
        this.driver.quit();
    }
}
