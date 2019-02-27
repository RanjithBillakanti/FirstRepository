package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductListScreen extends BaseScreen {
    public ProductListScreen(AndroidDriver driver) {
        super(driver);
    }
    String Item="(//android.widget.ImageView[contains(@resource-id,'rs_results_image')])[1]";

     public void SelectElement() throws InterruptedException {
         LocationCofigScreen loc=new LocationCofigScreen(driver);

        if(isElementPresent(By.xpath(loc.EnterPin))){
             loc.UseMyLocation();
             loc.EnterPinCode();
             System.out.println("I am in if of select item");
         }else {
            System.out.println("click on item");
            click(By.xpath(Item));
             System.out.println("I am in else of select item");
         }

        System.out.println("Into ProductListScreen's selectElement method");

    }

}
