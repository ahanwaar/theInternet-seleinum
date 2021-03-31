package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortableDataTables {

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
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement element = driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(4)"));
        element.click();
        WebElement dues = driver.findElement(By.cssSelector("#table1 tbody tr td:nth-of-type(4)"));

    }
}
