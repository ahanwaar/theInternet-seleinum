package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class EntryAd {

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
    public void testEntryAd() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/entry_ad");
        String currentWindow = driver.getWindowHandle();
        for ( String adwindow : driver.getWindowHandles() ) {
            if (adwindow != currentWindow) {
                driver.switchTo().window(adwindow);
                WebDriverWait wait = new WebDriverWait(driver, 5);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".modal-title")));
                System.out.println(driver.findElement(By.cssSelector(".modal-title")).getText());
                driver.findElement(By.cssSelector(".modal-footer p")).click();
            }
        }
        driver.switchTo().window(currentWindow);

    }

}
