package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSAlerts {

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
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement alert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        WebElement confirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        WebElement prompt =driver.findElement(By.xpath( "//button[text()='Click for JS Prompt']"));
        WebElement result = driver.findElement(By.id("result"));

        alert.click();
        Alert jsAlert = driver.switchTo().alert();
        Assert.assertEquals(jsAlert.getText(), "I am a JS Alert");
        jsAlert.accept();
        Assert.assertEquals(result.getText(), "You successfully clicked an alert");

        confirm.click();
        Alert jsConfirmAccept = driver.switchTo().alert();
        Assert.assertEquals(jsConfirmAccept.getText(), "I am a JS Confirm");
        jsConfirmAccept.accept();
        Assert.assertEquals(result.getText(), "You clicked: Ok");

        confirm.click();
        Alert jsConfirmCancel = driver.switchTo().alert();
        Assert.assertEquals(jsConfirmCancel.getText(), "I am a JS Confirm");
        jsConfirmCancel.dismiss();
        Assert.assertEquals(result.getText(), "You clicked: Cancel");

        prompt.click();
        Alert jsPrompt = driver.switchTo().alert();
        Assert.assertEquals(jsPrompt.getText(), "I am a JS prompt");
        jsPrompt.sendKeys("super text");
        jsPrompt.accept();
        Assert.assertEquals(result.getText(), "You entered: super text");

        prompt.click();
        jsPrompt = driver.switchTo().alert();
        Assert.assertEquals(jsPrompt.getText(), "I am a JS prompt");
        jsPrompt.sendKeys("super text");
        jsPrompt.dismiss();
        Assert.assertEquals(result.getText(), "You entered: null");
    }
}
