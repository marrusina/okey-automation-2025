package lib.ui.android;
import io.appium.java_client.AppiumDriver;
import lib.ui.WelcomePageObject;

public class AndroidWelcomePageObject extends WelcomePageObject
{
    static
    {
        DEVICE_LOCATION_DENY_BUTTON = "id:com.android.permissioncontroller:id/permission_deny_button";
        DEVICE_LOCATION_ONLY_ONCE_BUTTON = "id:com.android.permissioncontroller:id/permission_allow_one_time_button";
        DEVICE_LOCATION_WHILE_USING_APP_BUTTON = "id:com.android.permissioncontroller:id/permission_allow_foreground_only_button";
        GEOPOSITION_ACESS_DENY_BUTTON = "id:android:id/button2";
        GEOPOSITION_ACESS_SETTINGS_BUTTON = "id:android:id/button3";
        CHOOSE_SAINT_PETERSBURG_BUTTON = "xpath://android.widget.TextView[@text=\"Санкт-Петербург\"]";
        NEXT_AFTER_CITY_BUTTON = "id:ru.reksoft.okey:id/next";
        SKIP_CHOOSING_ADRESS = "id:ru.reksoft.okey:id/skip";
        ONLINE_SHOP_BUTTON = "xpath://android.widget.FrameLayout[@resource-id=\"ru.reksoft.okey:id/online\"]/android.view.ViewGroup";
        NOTIFICATION_ALLOW_BUTTON = "xpath://*[contains(@text,'ALLOW')]";
        STORIES_CLOSE = "id:ru.reksoft.okey:id/ias_close_button";
        CITY_SCREEN_NAME = "xpath://*[contains(@text,'Выберите регион')]";
        CITY_SCREEN_SEARCH_ICON = "id:ru.reksoft.okey:id/search";
        CITY_SCREEN_SEARCH_TEXT = "id:ru.reksoft.okey:id/search_text";
        CITY_SCREEN_BUTTON_NEXT = "id:ru.reksoft.okey:id/next";
        CITY_MOSCOW = "xpath://android.widget.TextView[@text=\"Москва\"]";
        CITY_SPB = "xpath://android.widget.TextView[@text=\"Санкт-Петербург\"]";
        CITY_ASTRAKH = "xpath://android.widget.TextView[@text=\"Астрахань\"]";
        CITY_VORONEZH = "xpath://android.widget.TextView[@text=\"Воронеж\"]";
        CITY_EKAT = "xpath://android.widget.TextView[@text=\"Екатеринбург\"]";
        CITY_IVANOVO = "xpath://android.widget.TextView[@text=\"Иваново\"]";
        CITY_IRKUTSK = "xpath://android.widget.TextView[@text=\"Иркутск\"]";
        CITY_KRASNODAR = "xpath://android.widget.TextView[@text=\"Краснодар\"]";
        CITY_KRASNOYARSK = "xpath://android.widget.TextView[@text=\"Красноярск\"]";
        CITY_LIPETSK = "xpath://android.widget.TextView[@text=\"Липецк\"]";
        CITY_MURM = "xpath://android.widget.TextView[@text=\"Мурманск\"]";
        CITY_NN = "xpath://android.widget.TextView[@text=\"Нижний Новгород\"]";
        CITY_NOVOSIB = "xpath://android.widget.TextView[@text=\"Новосибирск\"]";
        CITY_NOVOCHER = "xpath://android.widget.TextView[@text=\"Новочеркасск\"]";
        CITY_OMSK = "xpath://android.widget.TextView[@text=\"Омск\"]";
        CITY_ORENB = "xpath://android.widget.TextView[@text=\"Оренбург\"]";
        CITY_RND = "xpath://android.widget.TextView[@text=\"Ростов-на-Дону\"]";
        CITY_SCH = "xpath://android.widget.TextView[@text=\"Сочи\"]";
        CITY_SURGUT = "xpath://android.widget.TextView[@text=\"Сургут\"]";
        CITY_SKVK = "xpath://android.widget.TextView[@text=\"Сыктывкар\"]";
        CITY_TOL = "xpath://android.widget.TextView[@text=\"Тольятти\"]";
        CITY_TUM = "xpath://android.widget.TextView[@text=\"Тюмень\"]";
        CITY_UFA = "xpath://android.widget.TextView[@text=\"Уфа\"]";
    }

    public AndroidWelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
