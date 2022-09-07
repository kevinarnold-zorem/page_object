package Pages.sunat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {
    protected String URL;
    protected WebDriver driver;

    public Page(String URL) {
        this.URL = URL;
    }

    public WebDriver openPage(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(this.URL);
        return this.driver;
    }
    public void closePage(){
        this.driver.quit();
    }
}
