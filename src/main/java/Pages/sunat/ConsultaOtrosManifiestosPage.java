package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ConsultaOtrosManifiestosPage extends Page{
    private WebDriver driver;
    private By anoManifiestoField = By.name("CMc1_Anno");
    private By numManifiestoField = By.name("CMc1_Numero");
    private By codAduanaSelect = By.id("CG_cadu");
    private By codViaTransporteSelect = By.id("viat");
    private By btnConsultar = By.name("btnConsultar");
    public ConsultaOtrosManifiestosPage() {
        super("http://www.aduanet.gob.pe/cl-ad-itconsmanifiesto/manifiestoITS01Alias?accion=cargaConsultaManifiesto&tipoConsulta=salidaProvincia");
    }
    public void open(){
        this.driver = super.openPage();
    }
    public void close(){
        super.closePage();
    }
    public void setAnoManifiesto(String anoManifiesto) {
        Browser.waitForElement(this.driver, anoManifiestoField);
        WebElement el = this.driver.findElement(anoManifiestoField);
        el.sendKeys(Keys.CONTROL + "A");
        el.sendKeys(anoManifiesto);
    }
    public void setNumeroManifiesto(String numManifiesto) {
        Browser.waitForElement(this.driver, numManifiestoField);
        this.driver.findElement(numManifiestoField).sendKeys(numManifiesto);
    }

    public void selectCodAduana(String codigoAduana) {
        // Ejemplos: 217, 047
        Browser.waitForElement(this.driver, codAduanaSelect);
        findSelectElement(codAduanaSelect).selectByValue(codigoAduana);
    }

    public void selectViaTransporte(String viaTransporte) {
        Browser.waitForElement(this.driver, codViaTransporteSelect);
        findSelectElement(codViaTransporteSelect).selectByValue(viaTransporte);
    }

    private Select findSelectElement(By identifier){
        return new Select(this.driver.findElement(identifier));
    }


    public ReporteOtrosManifiestoPage clickConsultarButton() {
        this.driver.findElement(btnConsultar).click();
        return new ReporteOtrosManifiestoPage(this.driver);
    }
}
