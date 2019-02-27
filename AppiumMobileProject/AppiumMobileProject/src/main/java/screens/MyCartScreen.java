package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MyCartScreen extends BaseScreen {

    public MyCartScreen(AndroidDriver driver) {
        super(driver);
    }

    String cart="//android.widget.ImageView[contains(@resource-id,'action_bar_cart_image')]";
    String deleteItem="//android.widget.Button[contains(@text,'Delete')]";
    String itemName="//android.view.View[@index=0]";

    public void DeleteFromCart(){
        clicks(By.xpath(cart));
        waitAndClick(By.xpath(deleteItem));
        System.out.println("deleted itam from the cart");
        /*System.out.println( waitAndFindElement(By.xpath(itemName)).getText());
       System.out.println( waitAndFindElement(By.xpath(itemName)).getAttribute("value"));

*/
    }

}
