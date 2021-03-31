package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShiftingContent {
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
    public void testShiftContent() throws Exception {
        driver.get("http://the-internet.herokuapp.com/shifting_content/menu?mode=random&pixel_shift=100");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        int i =0;
        while (i<10){
            WebElement portfolio = driver.findElement(By.cssSelector("a[href='/portfolio/']"));
            WebElement gallery = driver.findElement(By.cssSelector("a[href='/gallery/']"));
            driver.navigate().refresh();
            i++;
        }

    }

    @Test
    public void testShiftImages(){
        driver.get("http://the-internet.herokuapp.com/shifting_content/image?pixel_shift=300");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        int i =0;
        while (i<10){
            WebElement image = driver.findElement(By.tagName("img"));
            wait.until(ExpectedConditions.visibilityOf(image));
            driver.navigate().refresh();
            i++;
        }
    }

    @Test
    public void testShiftLists(){
        driver.get("http://the-internet.herokuapp.com/shifting_content/list");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        int i =0;
        while (i<10){
            WebElement columns = driver.findElement(By.className("columns"));
            wait.until(ExpectedConditions.visibilityOf(columns));
            driver.navigate().refresh();
            i++;
        }
    }

}
