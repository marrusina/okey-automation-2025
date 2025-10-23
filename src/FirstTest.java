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
        capabilities.setCapability("app","C:/Users/rusina/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/" +
                "apks/app-debug.apk");

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
        WebElement elementPermission = waitForElementPresentByIdAndClick(
                "com.android.permissioncontroller:id/permission_deny_button",
                "cannot find permission deny button", 10);
        WebElement elementLocationCancel = waitForElementPresentByXpathAndClick(
                "//*[contains(@text,'CANCEL')]",
                "no cancel button",10);
        WebElement elementChooseCity = waitForElementPresentByXpathAndClick(
                "//android.widget.TextView[@text=\"Санкт-Петербург\"]",
                "cannot find city button", 10);
        WebElement elementNextButton = waitForElementPresentByIdAndClick(
                "ru.reksoft.okey:id/next",
                "Cannot find button Next", 10);
        WebElement elementSkip = waitForElementPresentByIdAndClick(
                "ru.reksoft.okey:id/skip",
                "Cannot find button SKIP", 10);
        WebElement elementNotificationAllow = waitForElementPresentByXpathAndClick(
                "//*[contains(@text,'ALLOW')]",
                "Cannot find button Allow notification", 10);

        WebElement elementCatalog = waitForElementPresentByXpathAndClick(
                "(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[2]",
                "cannot find catalog button", 10);
        WebElement elementSearch = waitForElementPresentByXpathAndClick("//*[contains(@text,'Search')]",
                "no field Search", 10);
        WebElement elementSearchSendKeys = waitForElementByIdAndSendKeys(
                "ru.reksoft.okey:id/search_field",
                "cannot find search field and send keys", "хлеб", 10);
        this.sendEnter();
        waitForElementPresentByXpath(
                "//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']",
        "Cannot find bread", 50);
    }

    public void sendEnter()
    {
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action","done"));
    }


    private WebElement waitForElementPresentByXpath(String xpath, String error, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        By by = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresentByXpath(String xpath, String error)
    {
        return waitForElementPresentByXpath(xpath, error, 5);
    }

    private WebElement waitForElementPresentByXpathAndClick(String xpath, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresentByXpath(xpath, error, timeOutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementPresentById(String id, String error, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        By by = By.id(id);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresentById(String id, String error)
    {
       return waitForElementPresentById(id, error, 5);
    }

    private WebElement waitForElementPresentByIdAndClick(String id, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresentByIdAndClick(id, error, timeOutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementByIdAndSendKeys(String id, String value, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresentById(id, error, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }


}
