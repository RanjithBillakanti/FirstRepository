package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class LocationCofigScreen extends BaseScreen {
    public LocationCofigScreen(AndroidDriver driver) {
        super(driver);
    }

    String useMyLocation = "//android.widget.Button[contains(@resource-id,'loc_ux_gps_auto_detect')]";
    String allow = "//android.widget.Button[contains(@resource-id,'permission_allow_button')]";
    //String clickOnEnterPin = "//android.widget.Button[@index='2']";
    String clickOnEnterPin = "//android.widget.Button[contains(@resource-id,'loc_ux_gps_enter_pincode')]";
    String EnterPin = "//android.widget.EditText[contains(@resource-id,'loc_ux_pin_code_text_pt1')]";
    String ApplyPin = "//android.widget.Button[contains(@resource-id,'loc_ux_update_pin_code')]";
    String loc = "//android.widget.LinearLayout[contains(@resource-id,'loc_ux_gps_auto_detect_segment')]";

    ProductDetailScreen prodDetail = new ProductDetailScreen(driver);

    public void UseMyLocation() {

        System.out.println("Into LocationCofigScreen's UseMyLocation method");
        // waitVisibility(By.xpath(useMyLocation));
        click(By.xpath(useMyLocation));
        click(By.xpath(allow));
    }

    public void EnterPinCode() {

        System.out.println("Into LocationCofigScreen's EnterPinCode method");
        try {
            waitAndClick(By.xpath(clickOnEnterPin));
            sendText(By.xpath(EnterPin), "560011");
            click(By.xpath(ApplyPin));
        } catch (Exception e) {
            System.out.println("No PopUp");
        }
    }

    public void checkIfLocationPopUp_Enterpin() throws InterruptedException {

        if (isElementPresent(By.xpath(clickOnEnterPin))) {
            EnterPinCode();
        } else if (isElementPresent(By.xpath(prodDetail.AddToCart))) {
            click(By.xpath(prodDetail.AddToCart));
        }
    }

    public void checkIfLocationPopUp_useMyLoc() throws InterruptedException {

        if (isElementPresent(By.xpath(useMyLocation))) {
            UseMyLocation();
        } else if (isElementPresent(By.xpath(prodDetail.AddToCart))) {
            click(By.xpath(prodDetail.AddToCart));
        }
    }
}