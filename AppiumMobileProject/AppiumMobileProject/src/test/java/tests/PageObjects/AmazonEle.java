package tests.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonEle {

    private static WebElement element;

    public static WebElement clickOnEnterPin(AndroidDriver driver) {
         element = driver.findElement(By.xpath("//android.widget.Button[@index='2']"));
        return element;
    }

    public static WebElement EnterPin(AndroidDriver driver) {
         element = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'loc_ux_pin_code_text_pt1')]"));
        return element;
    }

    public static WebElement ApplyPin(AndroidDriver driver) {
         element = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'loc_ux_update_pin_code')]"));
        return element;
    }

    public static WebElement CurrentLocation(AndroidDriver driver) {
         element = driver.findElement(By.xpath("//android.widget.Button[@index='1']"));
        return element;
    }

    public static WebElement allow(AndroidDriver driver) {
        element = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'permission_allow_button')]"));
        return element;
    }


}
