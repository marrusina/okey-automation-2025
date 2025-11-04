package lib.ui;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {
    protected AppiumDriver driver;
    public static final String
        BUTTON_BACK = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";

    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public void sendEnter()
    {
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action","done"));
    }

    public Boolean waitForElementNotPresent(By by, String error, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public WebElement waitForElementPresent(By by, String error, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(By by, String error)
    {
        return waitForElementPresent(by, error, 5);
    }

    public WebElement waitForElementPresentAndClick(By by, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error, timeOutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndClear(By by, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error, timeOutInSeconds);
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

    public void swipeUpAndFindElement(By by, String error, int max_swipes)
    {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes)
            {
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }

    }

    public void swipeLeft(By by, String error) throws InterruptedException {
        WebElement element = waitForElementPresent(by, error,10);
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
        this.waitForElementPresentAndClick(By.xpath(BUTTON_BACK),
                "Cannot click button Back", 10);
    }

}
