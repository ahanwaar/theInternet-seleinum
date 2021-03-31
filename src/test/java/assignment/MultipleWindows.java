package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
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
        driver.get("http://the-internet.herokuapp.com/windows");
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getCurrentUrl());
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        boolean IsNewWindowDataExists = driver.getPageSource().contains("New Window");
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window
        Assert.assertTrue(IsNewWindowDataExists);
    }
}
