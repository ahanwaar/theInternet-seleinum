package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JQueryUIMenus {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions builder = new Actions(driver);

        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");

        WebElement menuEnabled = driver.findElement(By.xpath( "//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]"));
        WebElement menuDownloads = driver.findElement(By.xpath("//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]/ul/li[1]"));
        List<WebElement> downloads = driver.findElements(By.xpath("//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]/ul/li[1]//li"));

        builder.moveToElement(menuEnabled).build().perform();
        builder.moveToElement(menuDownloads).build().perform();

        String uriPDF = downloads.get(0).getAttribute("href");
        String uriCSV = downloads.get(1).getAttribute("href");
        String uriExcel = downloads.get(2).getAttribute("href");
    }
}
