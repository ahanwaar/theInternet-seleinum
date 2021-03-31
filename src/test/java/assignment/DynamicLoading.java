package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicLoading {
    By startButton = By.cssSelector("#start button");
    By finishText = By.xpath(".//div[@id='finish']/h4");
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
    public void hiddenElementLoads() throws InterruptedException {
        testExample("1");
    }

    @Test
    public void elementAppears() throws InterruptedException {
        testExample("2");
    }

    public void testExample(String exampleNumber) throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/" + exampleNumber);
        driver.findElement(startButton).click();
        Thread.sleep(5000);
        Assert.assertEquals("The loaded text is incorrect", "Hello World!", driver.findElement(finishText).getText());
    }

}
