package lib.ui;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

abstract public class AllPageObject {
    protected AppiumDriver driver;
    protected static String BUTTON_BACK;

    //Определение конструктора класса, вызывается автоматически при создании нового экземпляра
    //класса наследника. Присваивает переменной driver значение AppiumDriver
    public AllPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }
    //Метод типа By принимает строку, разбивает ее на две части используя : и записывает первую часть в одну
    // переменную, а вторую часть в другую переменную. Потом возвращает вторую часть с присанным By.xpath
    // или By.id
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

    //ожидание, что элемент не присутствует
    public Boolean waitForElementNotPresent(String locator, String error, long timeOutInSeconds)
    {
        //преобразует строку локатора из метода в в объект By
        By by = this.getLocatorString(locator);
        //Создает экземпляр класса WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        //блокировка выполнения до выполнения условия
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //ожидание, что элемент присутствует с выбором своего таймаута
    public WebElement waitForElementPresent(String locator, String error, long timeOutInSeconds)
    {   //преобразует строку локатора из метода в в объект By
        By by = this.getLocatorString(locator);
        //Создает экземпляр класса WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        //блокировка выполнения до выполнения условия
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresentWithList(List<String> locators, String error, long timeOutInSeconds)
    {   List<By> byLocators = new ArrayList<>();
        for (String locatorString : locators) {
            byLocators.add(this.getLocatorString(locatorString));
        }
       //Создает экземпляр класса WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.withMessage(error + "\n");
        return wait.until(d -> {
            for (By by : byLocators) {
                List<WebElement> elements = d.findElements(by);
                if (!elements.isEmpty()) {
                    return elements.get(0); // Возвращаем первый найденный элемент
                }
            }
            return null; // Если ни один не найден, продолжаем ждать
        });
    }

    //дефолтное ожидание, что элемеент присутствует - время 5 сек
    public WebElement waitForElementPresent(String locator, String error)
    {
        return waitForElementPresent(locator, error, 5);
    }

    //ожидание, что элемент присутствует и клик по нему
    public WebElement waitForElementPresentAndClick(String locator, String error, long timeOutInSeconds)
    {
        //Возврашает веб элемент из метода waitForElementPresent
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        element.click();
        return element;
    }

    public boolean waitForElementPresentAndNotEnabled(String locator, String error, long timeOutInSeconds)
    {
        //Возврашает веб элемент из метода waitForElementPresent
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        boolean enabled = element.isEnabled();
        return !enabled;
    }

    public boolean waitForElementPresentAndEnabled(String locator, String error, long timeOutInSeconds)
    {
        //Возврашает веб элемент из метода waitForElementPresent
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        boolean enabled = element.isEnabled();
        return enabled;
    }

    //ожидание, что элемент присутствует и ввод строки
    public WebElement waitForElementAndSendKeys(String locator, String value, String error, long timeOutInSeconds)
    {
        //Возврашает веб элемент из метода waitForElementPresent
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        element.sendKeys(value);
        return element;
    }

    //ожидание, что элемент не присутствует и очистка строки
    public WebElement waitForElementAndClear(String locator, String error, long timeOutInSeconds)
    {
        //Возврашает веб элемент из метода waitForElementPresent
        WebElement element = waitForElementPresent(locator, error, timeOutInSeconds);
        element.clear();
        return element;
    }

    //Нажать на кнопку Back в МП
    public void clickBackButton()
    {
        waitForElementPresentAndClick(BUTTON_BACK,"Cannot click button Back", 10);
    }
    //выполнить Enter, нажать Enter на клавиатуре телефона
    public void sendEnter()
    {
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action","done"));
    }

    //Свайп вверх
    public void swipeUP(int timeOut)
    {
        //Создание объеката TouchAction
        TouchAction action = new TouchAction(driver);
        //Получениов размеры текущего окна (экрана) устройства (ширина и высота в пикселях)
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x,start_y).waitAction(timeOut).moveTo(x,end_y).release().perform();
    }

    //Быстрый свайп
    public void swipeUpQuick()
    {
        swipeUP(300);
    }

    //свайп, пока не будет найден элемент
    public void swipeUpAndFindElement(String locator, String error, int max_swipes)
    {
        //преобразует строку локатора из метода в в объект By
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

    //Свайп налево от определенного элемента
    public void swipeLeft(String locator, String error) throws InterruptedException
    {
        //Возврашает веб элемент из метода waitForElementPresent
        WebElement element = waitForElementPresent(locator, error,10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;
        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y).waitAction(150).moveTo(left_x,middle_y).release().perform().waitAction(900);
    }


}
