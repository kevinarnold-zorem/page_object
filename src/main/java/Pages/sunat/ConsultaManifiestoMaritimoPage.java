package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaManifiestoMaritimoPage extends Page{
    private WebDriver driver;
    private By anoManifiestoField = By.name("CMc1_Anno");
    private By numManifiestoField = By.name("CMc1_Numero");
    private By btnConsultar = By.xpath("//input[@onclick='jsConsultar()']");
    public ConsultaManifiestoMaritimoPage(){
        super("http://www.aduanet.gob.pe/cl-ad-itconsmanifiesto/manifiestoITS01Alias?accion=cargarFrmConsultaManifiestoExportacion");
    }
    public void open(){
        this.driver = super.openPage();
    }
    public void close(){
        super.closePage();
    }

    public void setAnoManifiesto(String anoManifiesto) {
        WebElement el = this.driver.findElement(anoManifiestoField);
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(anoManifiesto);
    }
    public void setNumManifiesto(String numManifiesto){
        this.driver.findElement(numManifiestoField).sendKeys(numManifiesto);
    }

    public ReporteManifiestoMaritimoPage clickConsultarButton(){
        this.driver.findElement(btnConsultar).click();
        return new ReporteManifiestoMaritimoPage(this.driver);
    }
}
