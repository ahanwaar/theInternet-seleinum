package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class ABTesting {

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
    public void helloWebDriver() throws Exception {
        driver.get("http://the-internet.herokuapp.com/abtest");
        WebElement pageHeading = driver.findElement(By.tagName("h3"));
        assertEquals("A/B Test Control", pageHeading.getText());
        WebElement paragraph = driver.findElement(By.tagName("p"));
        String paragraphTxt = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
        assertEquals(paragraphTxt,paragraph.getText());
        System.out.println("Test Passed");
    }
}
