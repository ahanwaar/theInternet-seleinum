package assignment;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class StatusCodecs {

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
    public void StatusCodes_200() throws FailingHttpStatusCodeException, IOException {
        WebClient webClient = new WebClient();
        int code = webClient.getPage("http://the-internet.herokuapp.com/status_codes/200").getWebResponse().getStatusCode();
        webClient.close();
        System.out.println(code);
        Assert.assertEquals(code, 200);
    }

    @Test
    public void StatusCodes_301() throws FailingHttpStatusCodeException, IOException {
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection con =
                (HttpURLConnection) new URL("http://the-internet.herokuapp.com/status_codes/301").openConnection();
        con.setRequestMethod("HEAD");
        int code = con.getResponseCode();
        System.out.println(code);
        Assert.assertEquals(code, 301);
    }


    @Test
    public void StatusCodes_404() throws FailingHttpStatusCodeException, IOException {
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection con =
                (HttpURLConnection) new URL("http://the-internet.herokuapp.com/status_codes/404").openConnection();
        con.setRequestMethod("HEAD");
        int code = con.getResponseCode();
        System.out.println(code);
        Assert.assertEquals(code, 404);
    }

    @Test
    public void StatusCodes_500() throws FailingHttpStatusCodeException, IOException {
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection con =
                (HttpURLConnection) new URL("http://the-internet.herokuapp.com/status_codes/500").openConnection();
        con.setRequestMethod("HEAD");
        int code = con.getResponseCode();
        System.out.println(code);
        Assert.assertEquals(code, 500);
    }
}
