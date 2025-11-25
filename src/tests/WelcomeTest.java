package tests;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

import lib.CoreTestCase;

public class WelcomeTest extends CoreTestCase {

    private AllPageObject AllPageObject;
    private WelcomePageObject WelcomePageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WelcomePageObject = WelcomePageObjectFactory.get(driver);
    }

    @Test
    public void testCheckCityScreen()
    {
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.checkCityScreenName();
        WelcomePageObject.checkCityScreenSearchIconAndText();
        WelcomePageObject.checkCityScreenNextButtonNotEnabled();
        WelcomePageObject.checkCityScreenCitiesList();
    }

    @Test
    public void testCheckCitiesInListAreClickable()
    {
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.checkCityScreenName();
        WelcomePageObject.checkCityScreenSearchIconAndText();
        WelcomePageObject.checkCityScreenNextButtonNotEnabled();
        WelcomePageObject.checkClicksOnCitiesScreen();

    }

    @Test
    public void testSearchInCitiesList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.checkCityScreenName();
        WelcomePageObject.checkCityScreenSearchIconAndText();
        WelcomePageObject.checkCityScreenNextButtonNotEnabled();
        SearchPageObject.searchSendKeys(WelcomePageObject.CITY_SCREEN_SEARCH_TEXT, "Красноярск","Cannot click search line on cities screen",10);
        WelcomePageObject.chooseCity(WelcomePageObject.CITY_KRASNOYARSK,"Cannot click RND", 10);

    }
    @Test
    public void testCheckSettingsButtonInGEO()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionSettingsButton();
        WelcomePageObject.checkApplicationSettings();

    }

    @Test
    public void testCheckCityChoosen()
    {
        ProfilePageObject ProfilePageObject = ProfilePageObjectFactory.get(driver);
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.checkCityScreenName();
        WelcomePageObject.checkCityScreenSearchIconAndText();
        WelcomePageObject.checkCityScreenNextButtonNotEnabled();
        WelcomePageObject.chooseCity(WelcomePageObject.CITY_SPB, "Cannot choose SPB", 10);
        WelcomePageObject.clickNextAfterChooseCity();
        WelcomePageObject.chooseOnlineShop();
        WelcomePageObject.skipChooseAddress();
        WelcomePageObject.chooseNotificationAllowButton();
        WelcomePageObject.closeStories();
        ProfilePageObject.clickProfileButtonNavigationPanel();
        ProfilePageObject.swipeOnProfileScreenToSeeCityName();
        ProfilePageObject.checkCityInProfileSpb();

    }

}
