package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptLoadEventError {

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
        driver.get("http://the-internet.herokuapp.com/javascript_error");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String errorRetrievalScript = "return window.__webdriver_javascript_errors;";
        System.out.println(js.executeScript(errorRetrievalScript));
    }
}
