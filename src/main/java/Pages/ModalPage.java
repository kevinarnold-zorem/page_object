package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalPage {
    private WebDriver driver;
    private By titleModalText = By.xpath("//div[@class='modal-title']//h3");
    private By closeModalButton = By.xpath(".//p[text()='Close']");
    public ModalPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCloseModalButton(){
        try{ Thread.sleep(1000); }catch (Exception e){}
        this.driver.findElement(closeModalButton).click();
    }


}
