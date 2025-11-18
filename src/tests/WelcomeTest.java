package tests;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

import lib.CoreTestCase;

public class WelcomeTest extends CoreTestCase {

    private MainPageObject MainPageObject;
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

}
