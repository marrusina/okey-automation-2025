package tests;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.ProfilePageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.MainPageObjectFactory;
import lib.ui.factories.ProfilePageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class MainScreenTest extends CoreTestCase{
    private MainPageObject MainPageObject;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = MainPageObjectFactory.get(driver);
    }

    @Test
    public void testMainScreenSearchBlock()
    {
        ProfilePageObject ProfilePageObject = ProfilePageObjectFactory.get(driver);
        WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.checkCityScreenName();
        WelcomePageObject.checkCityScreenSearchIconAndText();
        WelcomePageObject.checkCityScreenNextButtonNotEnabled();
        WelcomePageObject.chooseCity(WelcomePageObject.CITY_SPB, "Cannot choose SPB", 10);
        WelcomePageObject.clickNextAfterChooseCity();
        //WelcomePageObject.chooseOnlineShop();
        WelcomePageObject.skipChooseAddress();
        WelcomePageObject.chooseNotificationAllowButton();
        WelcomePageObject.closeStories();
        MainPageObject.checkSearchBlockAppearanceMainPage();
    }

    @Test
    public void testMainScreenSearchPositive()
    {
        ProfilePageObject ProfilePageObject = ProfilePageObjectFactory.get(driver);
        WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.checkCityScreenName();
        WelcomePageObject.checkCityScreenSearchIconAndText();
        WelcomePageObject.checkCityScreenNextButtonNotEnabled();
        WelcomePageObject.chooseCity(WelcomePageObject.CITY_SPB, "Cannot choose SPB", 10);
        WelcomePageObject.clickNextAfterChooseCity();
        //WelcomePageObject.chooseOnlineShop();
        WelcomePageObject.skipChooseAddress();
        WelcomePageObject.chooseNotificationAllowButton();
        WelcomePageObject.closeStories();
        MainPageObject.clickSearchFieldMainScreen();
        MainPageObject.searchMilkOnMainScreen();
    }
}
