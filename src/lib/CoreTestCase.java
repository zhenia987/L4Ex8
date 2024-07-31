package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

//В этот класс вынесем инициализацию наших тестов, а так же остановку и очистку
//Так же добавим после названия класса extends TestCase - это позволит нам использовать TestCase из junit.framework.TestCase
public class CoreTestCase extends TestCase {
    //Изменим вместо private на protected, так как этот аппиум драйвер будет использоваться в других классах
    protected AppiumDriver driver;

    //Вынесем в отдельную перемменую URL, который используется ниже в driver
    private static String AppiumURL = "http://localhost:4723/wd/hub/";


    //Убрали аннотацию  @Before

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/mbpro/Desktop/JavAppiumAutomation/JavaAppiumAuto/JavaAppiumAuto/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();
    }

    //Убрали аннотацию   @After
    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();

    }

    //Метод для поворота
    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

}
