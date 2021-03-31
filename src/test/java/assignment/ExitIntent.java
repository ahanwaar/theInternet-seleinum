package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExitIntent {
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
        driver.get("http://the-internet.herokuapp.com/exit_intent");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement modal = driver.findElement(By.cssSelector("#ouibounce-modal"));
        WebElement modalTitle = driver.findElement(By.cssSelector(".modal-title h3"));
        WebElement modalClose = driver.findElement(By.cssSelector(".modal-footer p"));

        System.out.println("checking that the modal is not displayed");
        Assert.assertFalse(modal.isDisplayed());

        //move mouse out of the window
        Actions actions = new Actions(driver);
        actions.moveByOffset(-10, -10).build().perform();

        wait.until(ExpectedConditions.visibilityOf(modal));

        System.out.println("checking that the modal is displayed");
        Assert.assertTrue(modal.isDisplayed());
        System.out.println(modalTitle.getText());
        modalClose.click();

        System.out.println("checking that the modal is not displayed");
        Assert.assertFalse(modal.isDisplayed());
    }
}
