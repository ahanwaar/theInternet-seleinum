package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Typos {
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
        driver.get("http://the-internet.herokuapp.com/typos");


        int i =0;
        while (i<10){
            List<WebElement> paragraphs = driver.findElements(By.xpath( "//div/p"));
            System.out.println(paragraphs.get(1).getText());
            driver.navigate().refresh();
            i++;
        }
    }
}
