package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HorizontalSlider {

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
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        WebElement range =driver.findElement(By.id("range"));
        slider.click();
        wait.until(ExpectedConditions.visibilityOf(slider));
        System.out.println("initial range value is " + range.getText());
        Dimension sliderSize = slider.getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = slider.getLocation().getX();

        Actions builder = new Actions(driver);
        builder.moveToElement(slider)
                .click()
                .dragAndDropBy(slider,xCoord+sliderWidth, 0)
                .build()
                .perform();

        int rangeValue = Integer.parseInt(
                range.getText());
        Assert.assertEquals(rangeValue, 5);

    }
}
