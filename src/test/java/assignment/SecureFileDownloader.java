package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecureFileDownloader {

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
    public void testSecureFileDownloader() throws InterruptedException {
        driver.get("http://admin:admin@the-internet.herokuapp.com/download_secure");
        Thread.sleep(2000);
        System.out.println("Before clicking");
        driver.findElement(By.linkText("New text.txt")).click();
        Thread.sleep(5000);
        System.out.println("File has downloaded");
    }
}
