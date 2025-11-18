//методы setUp и tearDown для всего проекта, методы работы с устройством для всего проекта
package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    //Метод переопределяет метод setUp из класса TestCase, автоматически вызывается перед выполнением
    // каждого теста.
    @Override
    protected void setUp() throws Exception
    {
        //Вызов базового метода класса TestCase
        super.setUp();
        // В переменную driver записывается драйвер из метода getDriver класса Platform, обращение к синглтону
        //гарантирует, что существует только 1 экземпляр класса Platform
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }

    //Метод для поворота экрана в портретную ориентацию
    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    //Метод для поворота экрана в лэндскейп ориентацию
    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    //Метод для работы в бэкграунде
    protected void runAppInBackground(int seconds)
    {
        driver.runAppInBackground(5);
    }


}
