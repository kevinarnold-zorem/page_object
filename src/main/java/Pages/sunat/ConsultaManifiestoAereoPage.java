package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsultaManifiestoAereoPage extends Page{
    private WebDriver driver;
    private By anoManifiestoText = By.name("CMc1_Anno");
    private By numManifiestoText = By.name("CMc1_Numero");
    private By btnConsultar = By.name("btnConsultar");
    public ConsultaManifiestoAereoPage() {
        super("http://www.aduanet.gob.pe/cl-ad-itconsmanifiesto/manifiestoITS01Alias?accion=cargaConsultaManifiesto&tipoConsulta=numeroManifiesto");
    }
    public void open(){
        this.driver = super.openPage();
    }
    public void close(){
        super.closePage();
    }

    public void setAnoManifiesto(String anoManifiesto){
        this.driver.findElement(anoManifiestoText).sendKeys(anoManifiesto);
    }
    public void setNumManifiesto(String numManifiesto){
        this.driver.findElement(numManifiestoText).sendKeys(numManifiesto);
    }
    public ReporteManifiestoAereoPage clickConsultarButton(){
        this.driver.findElement(btnConsultar).click();
        return new ReporteManifiestoAereoPage(this.driver);
    }
}
