package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement elementA = driver.findElement(By.id("column-a"));
        System.out.println(elementA.getAttribute("id"));
        WebElement elementB = driver.findElement(By.id("column-b"));
        int x=elementB.getLocation().getX();
        int y=elementB.getLocation().getY();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementA, elementB).build().perform();
        Thread.sleep(6000);
        driver.quit();
    }
}
