import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest
{
    private AppiumDriver driver;
    @Before
    public void SetUp() throws Exception
    {
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

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
        WebElement elementPermission = waitForElementPresentAndClick(
                By.id("com.android.permissioncontroller:id/permission_deny_button"),
                "cannot find permission deny button", 10);
        WebElement elementLocationCancel = waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'CANCEL')]"),
                "no cancel button",10);
        WebElement elementChooseCity = waitForElementPresentAndClick(
                By.xpath("//android.widget.TextView[@text=\"Санкт-Петербург\"]"),
                "cannot find city button", 10);
        WebElement elementNextButton = waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/next"),
                "Cannot find button Next", 10);
        WebElement elementSkip = waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/skip"),
                "Cannot find button SKIP", 10);
        WebElement elementNotificationAllow = waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'ALLOW')]"),
                "Cannot find button Allow notification", 10);

        WebElement elementCatalog = waitForElementPresentAndClick(
                By.xpath("(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[2]"),
                "cannot find catalog button", 10);
        WebElement elementSearch = waitForElementPresentAndClick(
                By.id("//*[contains(@text,'Search')]"),
                "no field Search", 10);
        WebElement elementSearchSendKeys = waitForElementAndSendKeys(
                By.id("ru.reksoft.okey:id/search_field"),
                "хлеб", "cannot find search field and send keys", 10);
        this.sendEnter();
        waitForElementPresent(
                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
        "Cannot find bread", 50);
        WebElement elementBack = waitForElementPresentAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "cannot find back and click",
                10);
        waitForElementNotPresent(
                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
                "Still seen bread", 30);
    }

    public void sendEnter()
    {
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action","done"));
    }

    private Boolean waitForElementNotPresent(By by, String error, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    private WebElement waitForElementPresent(By by, String error, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error)
    {
        return waitForElementPresent(by, error, 5);
    }

    private WebElement waitForElementPresentAndClick(By by, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error, timeOutInSeconds);
        element.click();
        return element;
    }


    private WebElement waitForElementAndSendKeys(By by, String value, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }


}
