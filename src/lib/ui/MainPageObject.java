package lib.ui;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

abstract public class MainPageObject {
    protected AppiumDriver driver;
    protected RemoteWebDriver driver2;
    protected static String
            BUTTON_BACK;

    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public MainPageObject(RemoteWebDriver remoteWebDriver) {
        this.driver2 = remoteWebDriver;

    }

    //выполнить Enter
    public void sendEnter()
    {
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action","done"));
    }

    //ожидание, что элемент не присутствует
    public Boolean waitForElementNotPresent(String locator, String error, long timeOutInSeconds)
    {
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //ожидание, что элемент присутствует с выбором своего таймаута
    public WebElement waitForElementPresent(String locator, String error, long timeOutInSeconds)
    {
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //дефолтное ожидание, что элемеент присутствует - время 5 сек
    public WebElement waitForElementPresent(String locator, String error)
    {
        return waitForElementPresent(locator, error, 5);
    }

    //ожидание, что элемент присутствует и клик по нему
    public WebElement waitForElementPresentAndClick(String locator, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        element.click();
        return element;
    }

    //ожидание, что элемент присутствует и ввод строки
    public WebElement waitForElementAndSendKeys(String locator, String value, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    //ожидание, что элемент не присутствует и очистка строки
    public WebElement waitForElementAndClear(String locator, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUP(int timeOut)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x,start_y).waitAction(timeOut).moveTo(x,end_y).release().perform();
    }

    public void swipeUpQuick()
    {
        swipeUP(300);
    }

    public void swipeUpAndFindElement(String locator, String error, int max_swipes)
    {
        By by = this.getLocatorString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes)
            {
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }

    }

    public void swipeLeft(String locator, String error) throws InterruptedException {
        WebElement element = waitForElementPresent(locator, error,10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;
        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y).waitAction(150).moveTo(left_x,middle_y).release().perform().waitAction(900);
    }

    public void clickBackButton()
    {
        this.waitForElementPresentAndClick(BUTTON_BACK,
                "Cannot click button Back", 10);
    }

    private By getLocatorString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String locator_type = exploded_locator[0];
        String locator = exploded_locator[1];
        if (locator_type.equals("xpath"))
        {
            return By.xpath(locator);
        }else if (locator_type.equals("id"))
        {
            return By.id(locator);
        }else
        {
            throw  new IllegalArgumentException("Cannot get type of locator" + locator_type);
        }
    }

}
