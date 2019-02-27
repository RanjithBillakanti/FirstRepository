package tests;

import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import screens.*;
import tests.Base.BaseUtil;
import utilities.Generic;

import java.io.IOException;
import java.net.URL;

public class BaseTest extends BaseUtil {

    public BaseTest(){

    }

    /********Dependecies injection******/

    BaseUtil baseUtil=new BaseUtil();
    public BaseTest(BaseUtil baseUtil)
    {
        this.baseUtil=baseUtil;
    }


     @Before
     public void Initial()
     {
        baseUtil.stepInfo="This is BaseUtil's string";
     }
    /*private BaseUtil base;

    public BaseTest(BaseUtil base){    //creating a constructor for BaseTest,
        // setting up a local variable for baseutil class and initializing local to super
        this.base=base;
    }*/
    /***********************************/
    public static AndroidDriver driver;
    public  AndroidDriver getDriver() {

        return driver;
    }

    public WebDriverWait wait;
    protected SplashScreen splashScreen = null;
    protected HomeScreen homeScreen = null;
    protected ProductListScreen productListScreen = null;
    protected ProductDetailScreen productDetailScreen = null;
    protected LocationCofigScreen locationCofigScreen = null;
    protected MyCartScreen myCartScreen=null;
    protected Generic generic=null;
    //protected boolean autoDismissAlerts = true;


    @BeforeMethod
    @Parameters({"deviceName", "platformVersion", "portNumber", "udid"})
    public void setup(String deviceName, String platformVersion, String portNumber, String UDID) throws IOException {
        System.out.println("TestNG Before");

        //baseUtil.stepInfo="Dependency injection";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("portNumber", portNumber);
        caps.setCapability("udid", UDID);
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "in.amazon.mShop.android.shopping");
        caps.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");
        caps.setCapability("noReset", "false");
       // caps.setCapability("autoDismissAlerts", true);

        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://192.168.12.75:" + portNumber + "/wd/hub"), caps));
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
        //tests.Base Screen Initialization
        splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());
        homeScreen = new HomeScreen(ThreadLocalDriver.getTLDriver());
        productDetailScreen = new ProductDetailScreen(ThreadLocalDriver.getTLDriver());
        productListScreen = new ProductListScreen(ThreadLocalDriver.getTLDriver());
        locationCofigScreen = new LocationCofigScreen(ThreadLocalDriver.getTLDriver());
        myCartScreen=new MyCartScreen(ThreadLocalDriver.getTLDriver());
        generic=new Generic(ThreadLocalDriver.getTLDriver());
    }}
