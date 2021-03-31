package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgetPasswordTest {

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
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("http://the-internet.herokuapp.com/forgot_password");
        WebElement email = driver.findElement(By.id("email"));
        WebElement submit = driver.findElement(By.id("form_submit"));

        email.sendKeys("no-reply@the-internet.herokuapp.com");
        submit.click();
    }


}
