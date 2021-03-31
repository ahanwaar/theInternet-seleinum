package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SortableDataTables {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testSort1() {
        List<WebElement> rows=driver.findElements(By.xpath("//tr"));
        System.out.println(rows.size());
    }

    @Test
    public void testSort2() throws Exception {
        List<WebElement> rows=driver.findElements(By.className("header"));
        List<WebElement> columns=driver.findElements(By.className("email"));
        System.out.println(rows.size());
        System.out.println(columns.size());
    }
}
