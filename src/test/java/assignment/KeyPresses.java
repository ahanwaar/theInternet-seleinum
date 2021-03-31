package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPresses {
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
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Key Presses')]")).click();
        Actions action = new Actions(driver);
        action.sendKeys("S").perform();;
        System.out.println(driver.findElement(By.cssSelector("p#result")).getText());

        Thread.sleep(3000);
        driver.quit();
    }
}
