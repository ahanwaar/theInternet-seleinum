package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationMessage {

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
    public void testNotificationMessage() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        boolean flag = true;
        while(flag) {
            driver.findElement(By.linkText("Click here")).click();
            System.out.println(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText());
            if(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText().contains("successful")){
                flag=false;
            }
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
