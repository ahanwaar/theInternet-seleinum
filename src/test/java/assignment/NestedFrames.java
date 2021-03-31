package assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NestedFrames {

    private WebDriver driver;
    private By bodyText = By.xpath("/html/body");


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
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        Assert.assertEquals("Body message is incorrect",getFrameText("left"),"LEFT");
        Assert.assertEquals("Body message is incorrect",getFrameText("bottom"),"BOTTOM");
    }

    private void switchToTopFrame() {
        driver.switchTo().frame("frame-top");
    }

    private void switchToBottomFrame() {
        driver.switchTo().frame("frame-bottom");
    }

    private void switchToFrame(String frame) {
        driver.switchTo().frame("frame-" + frame);
    }

    private void switchtoMainFrame() {
        driver.switchTo().defaultContent();
    }

    public String getFrameText(String frameName) {
        switch (frameName){
            case "left":
                switchToTopFrame();
                switchToFrame(frameName);
                break;
            case "right":
                switchToTopFrame();
                switchToFrame(frameName);
                break;
            case "middle":
                switchToTopFrame();
                switchToFrame(frameName);
                break;
            case "bottom":
                switchToBottomFrame();
                break;
        }
        String bodyText = driver.findElement(this.bodyText).getText();
        switchtoMainFrame();
        return bodyText;
    }
}
