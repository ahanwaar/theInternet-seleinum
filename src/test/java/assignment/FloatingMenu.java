package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FloatingMenu {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://the-internet.herokuapp.com/floating_menu");
        List<WebElement> paragraphs = driver.findElements(By.xpath( "//div[contains(@class, 'scroll')]/p"));
        WebElement home =driver.findElement(By.xpath( "//a[@href='#home']"));
        WebElement news = driver.findElement(By.xpath("//a[@href='#news']"));
        WebElement contact = driver.findElement(By.xpath("//a[@href='#contact']")); ;
        WebElement about= driver.findElement(By.xpath("//a[@href='#about']"));

        for (WebElement element : paragraphs){
            js.executeScript("arguments[0].scrollIntoView();", element);
            home.click();
            System.out.println(home.getText());
            news.click();
            System.out.println(news.getText());
            contact.click();
            System.out.println(contact.getText());
            about.click();
            System.out.println(about.getText());
        }

        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(5000);
    }
}
