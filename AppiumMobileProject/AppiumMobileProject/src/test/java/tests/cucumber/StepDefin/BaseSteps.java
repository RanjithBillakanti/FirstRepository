package tests.cucumber.StepDefin;

import Generics.Generic;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.*;

import tests.ThreadLocalDriver;

public    class BaseSteps {


    protected SplashScreen splashScreen=null ;
    protected HomeScreen homeScreen=null ;
    protected ProductListScreen productListScreen=null ;
    protected ProductDetailScreen productDetailScreen=null ;
    protected LocationCofigScreen locationCofigScreen=null ;
    protected MyCartScreen myCartScreen=null;
    protected WebDriverWait wait;
    protected Generic generic=null;

    //Screen Classes Initialization
    protected void setupCucumber () {
        System.out.println("Cucumber tests.Base Test Before-login-test-cucumber");
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 20);
        splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());
        homeScreen = new HomeScreen(ThreadLocalDriver.getTLDriver());
        productDetailScreen = new ProductDetailScreen(ThreadLocalDriver.getTLDriver());
        productListScreen = new ProductListScreen(ThreadLocalDriver.getTLDriver());
        locationCofigScreen = new LocationCofigScreen(ThreadLocalDriver.getTLDriver());
        myCartScreen=new MyCartScreen(ThreadLocalDriver.getTLDriver());
        generic=new Generic(ThreadLocalDriver.getTLDriver());
    }

    protected void teardown()
    {
        //tests.ThreadLocalDriver.getTLDriver().quit();
    }
}
