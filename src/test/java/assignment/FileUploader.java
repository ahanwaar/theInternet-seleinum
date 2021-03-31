package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploader {
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
    public void testFileUploader(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement uploadFileLink = driver.findElement(By.cssSelector("input#file-upload"));
        uploadFileLink.sendKeys("E:\\automation atypon\\New folder\\source\\pom.xml");
        WebElement uploadSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
        uploadSubmit.click();
    }
}
