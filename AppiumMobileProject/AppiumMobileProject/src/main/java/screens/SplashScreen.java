package screens;

import com.aventstack.extentreports.TestListener;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestListener.class)
public class SplashScreen extends BaseScreen {

    public SplashScreen(AndroidDriver driver) {
        super(driver);
    }
    String skipSignIn="//android.widget.Button[contains(@resource-id,'skip_sign_in_button')]";
   //String skipSignIn="//android.widget.Button[contains(@resource-id,'sk_sign_in_button')]";//wrong xpath to get screenshot

 public void skipSplashScreen() {
     System.out.println("we are 2 ");
        clicks(By.xpath(skipSignIn));
        }
}
