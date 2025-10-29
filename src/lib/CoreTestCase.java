package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","14.0");
        capabilities.setCapability("automationName","Appium");
        //capabilities.setCapability("appPackage","org.wikipedia");
        //capabilities.setCapability("appActivity",".main.MainActivity");
        //capabilities.setCapability("app","C:/Users/rusina/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/" +
        //"apks/org.wikipedia.apk");
        capabilities.setCapability("appPackage","ru.reksoft.okey");
        capabilities.setCapability("appActivity",".ui.activity.MainActivity");
        //capabilities.setCapability("app","C:/Users/rusina/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/" +
        // "apks/app-debug.apk");
        capabilities.setCapability("app","C:/Users/marina.rusina/Desktop/app-debug.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);

    }

    @Override
    protected void tearDown() throws Exception
    {

        driver.quit();
        super.tearDown();
    }

}
