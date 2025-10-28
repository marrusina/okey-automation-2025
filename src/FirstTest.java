import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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


//    @Test
//    public void firstTest()
//    {
//        WebElement elementPermission = waitForElementPresentAndClick(
//                By.id("com.android.permissioncontroller:id/permission_deny_button"),
//                "cannot find permission deny button", 10);
//        WebElement elementLocationCancel = waitForElementPresentAndClick(
//                By.xpath("//*[contains(@text,'CANCEL')]"),
//                "no cancel button",10);
//        WebElement elementChooseCity = waitForElementPresentAndClick(
//                By.xpath("//android.widget.TextView[@text=\"Санкт-Петербург\"]"),
//                "cannot find city button", 10);
//        WebElement elementNextButton = waitForElementPresentAndClick(
//                By.id("ru.reksoft.okey:id/next"),
//                "Cannot find button Next", 10);
//        WebElement elementSkip = waitForElementPresentAndClick(
//                By.id("ru.reksoft.okey:id/skip"),
//                "Cannot find button SKIP", 10);
//        WebElement elementNotificationAllow = waitForElementPresentAndClick(
//                By.xpath("//*[contains(@text,'ALLOW')]"),
//                "Cannot find button Allow notification", 10);
//
//        WebElement elementCatalog = waitForElementPresentAndClick(
//                By.xpath("(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[2]"),
//                "cannot find catalog button", 10);
//        waitForElementPresent(By.xpath("(//android.widget.TextView[@text=\"Catalogue\"])[1]"),
//            "cannot find Catalogue", 30);
//        swipeUpAndFindElement(
//               By.xpath("//*[@text='Books and stationery']\"]"),
//               "No such element after swipe"
//        );
        //swipeUpQuick();
//        WebElement elementSearch = waitForElementPresentAndClick(
//                By.xpath("//*[contains(@text,'Search')]"),
//                "no field Search", 20);
//        WebElement elementSearchSendKeys = waitForElementAndSendKeys(
//                By.id("ru.reksoft.okey:id/search_field"),
//                "хлеб", "cannot find search field and send keys", 10);
//        this.sendEnter();
//       waitForElementPresent(
//                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
//       "Cannot find bread", 50);
//
        //waitForElementAndClear(By.id(
          //      "ru.reksoft.okey:id/search_field"),
         //       "cannot clear search field", 10);
//        WebElement elementBack = waitForElementPresentAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
//                "cannot find back and click",
//                10);
//        waitForElementNotPresent(
//                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
//                "Still seen bread", 30);
//        waitForElementPresentAndClick(
//                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
//                "Cannot find bread", 50);
//        WebElement elementBread = waitForElementPresent(
//                        By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
//                "Cannot find bread", 50);
//        String bread = elementBread.getAttribute("text");
//        Assert.assertEquals(
//                "Text for bread is wrong",
//                "Хлеб Английский диетический в нар.400г Каравай",
//                bread
//        );
 //   }

    @Test
    public void swipeTest() throws InterruptedException {
        WebElement elementPermission = waitForElementPresentAndClick(
                By.id("com.android.permissioncontroller:id/permission_deny_button"),
                "cannot find permission deny button", 10);
        WebElement elementLocationCancel = waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'CANCEL')]"),
                "no cancel button", 10);
        WebElement elementChooseCity = waitForElementPresentAndClick(
                By.xpath("//android.widget.TextView[@text=\"Санкт-Петербург\"]"),
                "cannot find city button", 10);
        WebElement elementNextButton = waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/next"),
                "Cannot find button Next", 10);
        WebElement elementOnlineShop = waitForElementPresentAndClick(
                By.xpath("//android.widget.FrameLayout[@resource-id=\"ru.reksoft.okey:id/online\"]/android.view.ViewGroup"),
                "Cannot find online shop button",
                20);
        WebElement elementSkip = waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/skip"),
                "Cannot find button SKIP", 10);
        WebElement elementNotificationAllow = waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'ALLOW')]"),
                "Cannot find button Allow notification", 10);
        WebElement elementStoriesToClose = waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/ias_close_button"),
                "Cannot close Stories",
                10);
        WebElement elementCatalog = waitForElementPresentAndClick(
                By.xpath("(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[1]"),
                "cannot find main button", 10);
        waitForElementPresent(
                By.id("ru.reksoft.okey:id/book_delivery"),
                "it's not the main screen", 30);
        swipeUpAndFindElement(
                //By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/title\" and @text=\"Children\"]"),
                By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/name\" and @text=\"Кашка без молока ФрутоНяня гречневая ...\"]"),
                "No such element after swipe",
                20);
        waitForElementPresentAndClick(
                        By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/name\" and @text=\"Кашка без молока ФрутоНяня гречневая ...\"]"),
                "Cannot find porridge",
                50);
        WebElement elementAddToCart = waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/add"),
                "Cannot add product to cart",
                10);
        WebElement elementCart = waitForElementPresentAndClick(
                By.xpath("(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[4]"),
                "cannot find cart button", 10);
        waitForElementPresent(
                By.id("ru.reksoft.okey:id/name"),
                "No product in cart",
                20);
        WebElement elementChQty = waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/itemQuantity"),
                "Cannot click to change quantity",
                10);
        WebElement elementTwoPcs = waitForElementPresentAndClick(
                By.xpath("//*[@text='2 pcs']"),
                "Cannot choose 2 pcs",
                10);
        WebElement elementQuantity = waitForElementPresent(
                By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/itemQuantity\" and @text=\"2 pcs\"]"),
                "cannot find quantity",
                10);
        swipeLeft(
                By.id("ru.reksoft.okey:id/name"),
                "cannot swipe left"
        );
        WebElement elementDeleteInCart = waitForElementPresentAndClick(
                By.xpath("//android.widget.LinearLayout[@resource-id=\"ru.reksoft.okey:id/bottom_wrapper\"]/android.widget.ImageButton[2]"),
                "Cannot delete product in cart",
                15);

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

    private WebElement waitForElementAndClear(By by, String error, long timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error, timeOutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeUP(int timeOut)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x,start_y).waitAction(timeOut).moveTo(x,end_y).release().perform();
    }

    protected void swipeUpQuick()
    {
        swipeUP(300);
    }

    protected void swipeUpAndFindElement(By by, String error, int max_swipes)
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

    protected void swipeLeft(By by, String error) throws InterruptedException {
        WebElement element = waitForElementPresent(by, error,10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;
        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y).waitAction(150).moveTo(left_x,middle_y).release().perform().waitAction(900);
    }




}
