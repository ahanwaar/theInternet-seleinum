package assignment;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class RedirectLink {

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
    public void testRedirectLink() throws IOException, InterruptedException {
        driver.get("http://the-internet.herokuapp.com/redirector");
        WebElement redirectLink = driver.findElement(By.cssSelector("a#redirect"));
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(redirectLink.getAttribute("href"));
        CloseableHttpResponse httpResponse=httpclient.execute(httpGet);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        redirectLink.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
