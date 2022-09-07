package Pages.sunat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class Browser {

    /*public static WebDriver open(String url){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }*/

    public static void waitForElement(WebDriver driver, final By webElementIdentifier){
        int timeOut = 90;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                if (driver.findElement(webElementIdentifier) != null){
                    return Boolean.TRUE;
                }
                return null;
            }
        });
    }
    public static WebDriver getChildWindow(WebDriver driver){
        WebDriver childDriver = null;
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                childDriver = driver.switchTo().window(ChildWindow);
            }
        }
        return childDriver;
    }
}
