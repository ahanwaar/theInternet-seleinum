package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class InfiniteScroll {

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
    public void test() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/infinite_scroll");
        List<WebElement> images = driver.findElements(By.cssSelector(".figure"));
        Actions action = new Actions(driver);
        for(WebElement image:images) {
            action.moveToElement(image).perform();
            System.out.println(image.findElement(By.cssSelector(".figcaption")).isDisplayed());
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
