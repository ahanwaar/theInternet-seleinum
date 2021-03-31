package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DisappearingElements {

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
        driver.get("http://the-internet.herokuapp.com/disappearing_elements");
        List<WebElement> elementList= driver.findElements(By.xpath("//div[@class='example']/ul/li"));
        System.out.println(elementList.size());



        try{
            for (WebElement element : elementList){
                System.out.println(element.getText());
            }
        } catch (Exception e){
            System.out.println("Element Gallery is not present");
        }

    }
}
