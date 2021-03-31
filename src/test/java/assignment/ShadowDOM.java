package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {
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
        driver.get("http://the-internet.herokuapp.com/shadowdom");
        System.out.println("Validate downloads page header text");
        WebElement root1 = driver.findElement(By.cssSelector("my-paragraph"));
        WebElement shadowRoot1 = expandRootElement(root1);
       // WebElement root2 = shadowRoot1.findElement(By.cssSelector("span"));
      //  WebElement shadowRoot2 = expandRootElement(root2);

    }

    public WebElement expandRootElement(WebElement element) {
        return (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", element);

    }
}
