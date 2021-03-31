package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicControls {

    public WebElement element;
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
    public void refreshBrowser() throws Exception {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.navigate().refresh();
    }

    @Test
    public void dynamicButton() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        WebElement element1 = driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
        element.click();
        Thread.sleep(1000);
        element1.click();
        Thread.sleep(1000);

    }
}
