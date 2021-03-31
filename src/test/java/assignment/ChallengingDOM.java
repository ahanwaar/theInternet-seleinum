package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class ChallengingDOM{

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
        driver.get("http://the-internet.herokuapp.com/challenging_dom");

        WebElement alertButton = driver.findElement(By.xpath("//*[contains(@class, 'large-2')]/a[@class='button alert']"));
        WebElement sit5 = driver.findElement(By.xpath("//*[contains(@class, 'large-10')]/table/tbody/tr[6]/td[4]"));
        WebElement edit7 = driver.findElement(By.xpath("//*[contains(@class, 'large-10')]/table/tbody/tr[8]/td[7]/a[1]"));

        Assert.assertEquals(3, alertButton.getText().length());
        Assert.assertEquals("Definiebas5", sit5.getText());
        Assert.assertEquals(edit7.getText(), "edit");

    }
}
