package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReporteManifiestoAereoPage  {
    private WebDriver driver;
    public ReporteManifiestoAereoPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getConsignatario(String numConocimiento){
        String xpath = "((//a[contains(text(), '"+numConocimiento+"')]//parent::td)//parent::tr//td)[11]";
        String x = "((//a[contains(text(), '000420320584')]//parent::td)//parent::tr//td)[11]";
        return this.driver.findElement(By.xpath(xpath)).getText();
    }
    public void close(){
        this.driver.quit();
    }
}
