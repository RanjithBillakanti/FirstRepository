package screens;

import io.appium.java_client.android.AndroidDriver;

public class WishListScreen extends BaseScreen {


    public WishListScreen(AndroidDriver driver) {
        super(driver);
    }

    String YourWishList="//android.widget.TextView[contains(@text,'Your Wish List')]";
}
