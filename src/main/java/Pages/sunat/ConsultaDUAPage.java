package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ConsultaDUAPage extends Page{
    private WebDriver driver;

    private By regimenAsociadoSelect = By.id("sel_cod_regimen");
    private By codAduanaSelect = By.name("codaduana");
    private By anoDeclaracionField = By.name("anoprese");
    private By numDeclaracionField = By.id("txt_num_declaracion");
    private By btnConsultar = By.xpath("//input[@onclick='enviar()']");

    public ConsultaDUAPage() {
        super("https://ww3.sunat.gob.pe/aduanas/informli/ildua.htm");
    }

    public void open(){
        this.driver = super.openPage();
    }
    public void close(){
        super.closePage();
    }
    private Select findSelectElement(By identifier){
        return new Select(this.driver.findElement(identifier));
    }

    public void selectRegimenAsociado(String regimenAsociado){
        findSelectElement(regimenAsociadoSelect).selectByValue(regimenAsociado);
    }
    public void selectCodAduana(String codAduana){
        findSelectElement(codAduanaSelect).selectByValue(codAduana);
    }

    public void setAnoDeclaracion(String anoDeclaracion){
        this.driver.findElement(anoDeclaracionField).sendKeys(anoDeclaracion);
    }

    public void setNumDeclaracion(String numDeclaracion){
        this.driver.findElement(numDeclaracionField).sendKeys(numDeclaracion);
    }

    public ReporteDUAPage clickConsultarButton(){
        this.driver.findElement(btnConsultar).click();
        return new ReporteDUAPage(this.driver);
    }
}
