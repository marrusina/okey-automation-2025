package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Platform {
    private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    //Объявление приватной статической переменной, реализация Синглтона.
    private static Platform instance;
    //Приватный конструктор по умолчанию для класса Platform(имя должно совпадать с именем класса),
    // чтобы нельзя было создать объект извне при помощи new
    private Platform() {}
    //Публичный статический метод для доступа к экземпляру
    public static Platform getInstance()
    {
        if (instance == null)
        {instance = new Platform();
        }
        return instance;
    }

    //Метод использует внутри себя методы для сравнения системной переменной Platform с введенными значениями
    // и возвращают тип драйвера с урлом и capabilities
    public AppiumDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid())
        {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        }
        else if (this.isIOS())
        {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        }
        else
        {
            throw new Exception("Cannot detect type of driver" + this.getPlatformVar());
        }
    }
    //Метод вызывает метод isPlatform со значением Android, который сравнивает текущую системную переменную с Android
    public boolean isAndroid(){return isPlatform(PLATFORM_ANDROID);}
    //Метод вызывает метод isPlatform со значением IOS, который сравнивает текущую системную переменную с IOS
    public boolean isIOS(){return isPlatform(PLATFORM_IOS);}
    //Проверка совпадает ли системная переменная PLATFORM с входной строкой my_platform
    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }
    //Метод получает системную переменную Platform и возвращает ее в виде строки
    private String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }
    private DesiredCapabilities getIOSDesiredCapabilities() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","IOS");
        capabilities.setCapability("deviceName","Some device");
        capabilities.setCapability("platformVersion","14.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app","C:/Users/marina.rusina/Desktop/some.app");
        return capabilities;
    }

    private DesiredCapabilities getAndroidDesiredCapabilities() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("automationName", "Appium");
        //capabilities.setCapability("appPackage","org.wikipedia");
        //capabilities.setCapability("appActivity",".main.MainActivity");
        //capabilities.setCapability("app","C:/Users/rusina/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/" +
        //"apks/org.wikipedia.apk");
        capabilities.setCapability("appPackage", "ru.reksoft.okey");
        capabilities.setCapability("appActivity", ".ui.activity.MainActivity");
        //capabilities.setCapability("app","C:/Users/rusina/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/" +
        // "apks/app-debug.apk");
        capabilities.setCapability("app", "C:/Users/marina.rusina/Desktop/app-debug.apk");
        return capabilities;
    }


}
