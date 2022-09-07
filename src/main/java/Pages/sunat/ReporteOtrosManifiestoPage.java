package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReporteOtrosManifiestoPage {
    private WebDriver driver;

    public ReporteOtrosManifiestoPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getConsignatario(String numConocimiento){
        String xpath = "((//a[contains(text(), '"+numConocimiento+"')]//parent::td)//parent::tr//td)[12]";
        String x = "((//a[contains(text(), 'COSU6332033950')]//parent::td)//parent::tr//td)[12]";
        return this.driver.findElement(By.xpath(xpath)).getText();
    }
    public void close(){
        this.driver.quit();
    }
}
