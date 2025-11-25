package lib.ui;
import io.appium.java_client.AppiumDriver;

import java.util.Arrays;
import java.util.List;

abstract public class WelcomePageObject extends AllPageObject {
    public static String
    CHOOSE_SAINT_PETERSBURG_BUTTON, CITY_SPB, CITY_TUM, CITY_KRASNOYARSK, CITY_SCREEN_SEARCH_TEXT;
    protected static String
    DEVICE_LOCATION_DENY_BUTTON, DEVICE_LOCATION_ONLY_ONCE_BUTTON, DEVICE_LOCATION_WHILE_USING_APP_BUTTON, GEOPOSITION_ACESS_DENY_BUTTON,
    GEOPOSITION_ACESS_SETTINGS_BUTTON, NEXT_AFTER_CITY_BUTTON, SKIP_CHOOSING_ADRESS, ONLINE_SHOP_BUTTON, NOTIFICATION_ALLOW_BUTTON,
    STORIES_CLOSE, CITY_SCREEN_NAME, CITY_SCREEN_SEARCH_ICON, CITY_SCREEN_BUTTON_NEXT, CITY_MOSCOW,
    CITY_ASTRAKH, CITY_VORONEZH, CITY_EKAT, CITY_IVANOVO, CITY_IRKUTSK, CITY_KRASNODAR, CITY_LIPETSK,
    CITY_MURM, CITY_NN, CITY_NOVOSIB, CITY_NOVOCHER, CITY_OMSK, CITY_ORENB, CITY_RND, CITY_SCH, CITY_SURGUT, CITY_SKVK, CITY_TOL,
    CITY_UFA, ABOUT_APPLICATION;

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }
//    public void accessToDeviceLocation(By by, String error, int time)
//    {
//        this.waitForElementPresentAndClick(by,error,time);
//    }
    //Клик по кнопке Отказ в доступе к данным о геолокации устройства
    public void accessToDeviceLocationDenyButton()
    {
        this.waitForElementPresentAndClick(DEVICE_LOCATION_DENY_BUTTON,
                        "Cannot click location deny button", 10);
    }

    public void accessToGeoPositionDenyButton()
    {
        this.waitForElementPresentAndClick(GEOPOSITION_ACESS_DENY_BUTTON,
                "Cannot click deny button for geoposition",
                10);
    }

    public void accessToGeoPositionSettingsButton()
    {
        this.waitForElementPresentAndClick(GEOPOSITION_ACESS_SETTINGS_BUTTON, "Cannot click settings button for GEO", 10);
    }

    public void checkCityScreenName()
    {
        this.waitForElementPresent(CITY_SCREEN_NAME, "Cannot see city screen name", 10);
    }

    public void checkCityScreenSearchIconAndText()
    {
        waitForElementPresent(CITY_SCREEN_SEARCH_ICON, "Cannot see search icon", 10);
        waitForElementPresent(CITY_SCREEN_SEARCH_TEXT, "Cannot see text Search", 10);
    }

    public void checkCityScreenNextButtonNotEnabled()
    {
        waitForElementPresentAndNotEnabled(CITY_SCREEN_BUTTON_NEXT,"Button is not seen or enabled", 10);
    }

    public void checkCityScreenNextButtonEnabled()
    {
        waitForElementPresentAndEnabled(CITY_SCREEN_BUTTON_NEXT,"Button is not seen or not enabled", 10);
    }

    public void checkCityScreenCitiesList()
    {
        List<String> cities1 = Arrays.asList(CITY_MOSCOW,CITY_SPB, CITY_ASTRAKH, CITY_VORONEZH, CITY_EKAT, CITY_IVANOVO, CITY_IRKUTSK,
                CITY_KRASNODAR, CITY_KRASNOYARSK, CITY_LIPETSK);
        List<String> cities2 = Arrays.asList(CITY_MURM, CITY_NN, CITY_NOVOSIB, CITY_NOVOCHER, CITY_OMSK, CITY_ORENB, CITY_RND,
                CITY_SCH, CITY_SURGUT, CITY_SKVK);
        List<String> cities3 = Arrays.asList(CITY_NOVOCHER, CITY_OMSK, CITY_ORENB, CITY_RND,
                CITY_SCH, CITY_SURGUT, CITY_SKVK, CITY_TOL, CITY_TUM, CITY_UFA);

        waitForElementPresentWithList(cities1,"Cannot see all citie's 1 list", 20);
        //swipeUpAndFindElement(CITY_SKVK, "Cannot swipe or see Suktuvkar", 5);
        //waitForElementPresentWithList(cities2, "Cannot see all citie's 2 list", 10);
        swipeUpAndFindElement(CITY_UFA, "Cannot swipe or see UFA", 5);
        waitForElementPresentWithList(cities3, "Cannot see all citie's 3 list", 10);
    }

    public void checkClicksOnCitiesScreen()
    {
        waitForElementPresentAndClick(CITY_SPB, "Cannot click SPB", 10);
        checkCityScreenNextButtonEnabled();
        waitForElementPresentAndClick(CITY_KRASNOYARSK, "Cannot click SPB", 10);
        checkCityScreenNextButtonEnabled();
        swipeUpAndFindElement(CITY_TUM, "Cannot swipe and see Tumen", 10);
        waitForElementPresentAndClick(WelcomePageObject.CITY_TUM, "Cannot click Tumen", 10);
    }

    public void checkApplicationSettings()
    {
        this.waitForElementPresent(ABOUT_APPLICATION, "Cannot see settings screen",10);
    }

    public void chooseCity(String locator, String error, int time)
    {
        this.waitForElementPresentAndClick(locator,error,time);
    }

    public void clickNextAfterChooseCity()
    {
        this.waitForElementPresentAndClick(NEXT_AFTER_CITY_BUTTON,
                "Cannot click Next button after choosing city",
                10);
    }

    public void skipChooseAddress()
    {
        this.waitForElementPresentAndClick(SKIP_CHOOSING_ADRESS,
                "Cannot click Skip for choosing address",
                10);
    }

    public void chooseOnlineShop()
    {
        this.waitForElementPresentAndClick(ONLINE_SHOP_BUTTON,
                "Cannot find online shop button",
                20);
    }

    public void chooseNotificationAllowButton()
    {
        this.waitForElementPresentAndClick(NOTIFICATION_ALLOW_BUTTON,
                "Cannot find button Allow notification",
                10);
    }

    public void closeStories()
    {
        this.waitForElementPresentAndClick(STORIES_CLOSE,
                "Cannot close Stories", 10);
    }
}
