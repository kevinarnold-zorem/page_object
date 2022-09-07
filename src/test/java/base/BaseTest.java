package base;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        // this.driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS)
        goHome();

        // System.out.println(driver.getTitle());

        this.driver.manage().window().maximize();
        // driver.manage().window().fullscreen();
        // driver.manage().window().setSize(new Dimension(375,812));

        // Buscar y capturar/seleccionar elementos de una página web
        // List<WebElement> links = driver.findElements(By.tagName("a"));
        // System.out.println("Cantidad de enlaces: " + links.size());

        // Buscar y capturar/seleccionar  un elementos de una página web para interactuar con él
        // WebElement link = driver.findElement(By.linkText("Inputs"));
        // link.click();

        // Intentar capturar/seleccionar un elemento que no existe
        // WebElement linkNotFound = driver.findElement(By.linkText("Angie"));
        // linkNotFound.click();

        // Ejercicio 01:
        // findingWebElement(driver);

        this.homePage = new HomePage(this.driver);

    }

    @BeforeMethod
    public void goHome(){
        this.driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void tearDown(){
        try{ Thread.sleep(2000);} catch (Exception e){}
        this.driver.quit();
    }


    // EXCERCISE CHAPTER 3: FINDING WEB ELEMENTS
    public static void findingWebElement(WebDriver driver){
        WebElement shiftingLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingLink.click();
        WebElement menuElement = driver.findElement(By.linkText("Example 1: Menu Element"));
        menuElement.click();
        List<WebElement> listMenuItems = driver.findElements(By.tagName("li"));
        System.out.println("Cantidad de menu items: " + listMenuItems.size());
    }

}
