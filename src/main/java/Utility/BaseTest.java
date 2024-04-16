package Utility;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static RemoteWebDriver driver = null;
    public static final String USERNAME = "sonnguyenh";
    public static final String ACCESS_KEY = "access_key";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";


    @Parameters({"browser", "platform", "version"})
    @BeforeMethod
    public static void openBrowser(String browser, String platform, String version) throws MalformedURLException {
        if(browser.equalsIgnoreCase("Chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPlatformName(platform);
            chromeOptions.setBrowserVersion(version);
            URL url = new URL(URL);
            driver = new RemoteWebDriver(url, chromeOptions);
        } else if(browser.equalsIgnoreCase("Edge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPlatformName(platform);
            edgeOptions.setBrowserVersion(version);
            URL url = new URL(URL);
            driver = new RemoteWebDriver(url, edgeOptions);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

//    public static void closeBrowser() {
//        if(driver != null) {
//            driver.quit();
//        }
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
