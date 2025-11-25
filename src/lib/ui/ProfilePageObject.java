package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class ProfilePageObject extends AllPageObject
{
    public static String
    NAVIGATION_PROFILE_BUTTON,
    CITY_IN_PROFILE_SPB;

    public ProfilePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickProfileButtonNavigationPanel()
    {
        this.waitForElementPresentAndClick(NAVIGATION_PROFILE_BUTTON, "Cannot click profile button in Navigation Panel", 10);
    }

    public void checkCityInProfileSpb()
    {
        this.waitForElementPresent(CITY_IN_PROFILE_SPB,
                "It's not SPB", 10);
    }

    public void swipeOnProfileScreenToSeeCityName()
    {
        swipeUpAndFindElement(CITY_IN_PROFILE_SPB, "Cannot swipe to see city name", 10);
    }
}
