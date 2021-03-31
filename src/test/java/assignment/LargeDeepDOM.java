package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LargeDeepDOM {

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
        driver.get("http://the-internet.herokuapp.com/large");
        WebElement noSiblings = driver.findElement(By.id("no-siblings"));
        WebElement divId = driver.findElement(By.xpath("//div[@id='sibling-41.2']"));
        WebElement tableId =driver.findElement(By.cssSelector(".row-20 .column-33"));


        Assert.assertEquals(noSiblings.getText(), "No siblings");
        Assert.assertEquals(divId.getText(), "41.2");
        Assert.assertEquals(tableId.getText(), "20.33");
    }
}
