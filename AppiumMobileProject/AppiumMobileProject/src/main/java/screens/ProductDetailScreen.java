package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductDetailScreen extends BaseScreen {
    public ProductDetailScreen(AndroidDriver driver) {
        super(driver);
    }

    String AddToCart = "//android.widget.Button[contains(@resource-id,'add-to-cart-button')]";
    String ProductFullView = "//android.view.View[@index='2']";

    public void AddingToCart() throws InterruptedException {
        LocationCofigScreen loc = new LocationCofigScreen(driver);

               System.out.println("Going to scroll now");
               Scrolling();

               clicks(By.xpath(AddToCart));

               if(loc.isElementPresent(By.xpath(loc.clickOnEnterPin))){
                   loc.EnterPinCode();
           }
            System.out.println("Into ProductDetailScreen's AddingToCart method");
        }

}




