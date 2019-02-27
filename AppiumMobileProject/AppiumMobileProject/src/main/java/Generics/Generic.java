package Generics;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;


public class Generic {


    AndroidDriver driver;

    public Generic(AndroidDriver driver) {
        this.driver = driver;
    }


// Create instance of Javascript executor

    // JavascriptExecutor je = (JavascriptExecutor) driver;

/*

//Identify the WebElement which will appear after scrolling down

    WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));

((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element));

// now execute query which actually will scroll until that element is not appeared on page.

je.executeScript("arguments[0].scrollIntoView(true);",element)*/

    public void scrollTillAddToCart() throws InterruptedException {
        System.out.println("Scrolling down");
        for (int i = 0; i <= 2; i++) {
            Dimension size1 = driver.manage().window().getSize();

            int startX = size1.getWidth() / 2;
            System.out.println(startX);
            int startY = size1.getHeight() / 2;
            System.out.println(startY);
            int endX = 0;
            int endY = (int) (startY * -1 * 0.75);
            //endY= endY/4;
            System.out.println(endY);

            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
            Thread.sleep(2000);

        }

    }


        //WebElement elementName = driver.findElement(By.xpath("//android.widget.Button[@index='0']"));
       /* Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build(). perform();*/


      // public static void scrollToElement(AndroidDriver driver, String elementName, boolean scrollDown){
           /* String listID = ((RemoteWebElement) driver.findElementByAndroidUIAutomator("//android.widget.Button[contains(@resource-id,'add-to-cart-button')]")).getId();
            String direction;
            if (scrollDown) {
                direction = "down";
            } else {
                direction = "up";
            }
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", direction);
            scrollObject.put("element", listID);
            scrollObject.put("text", elementName);
            driver.executeScript("mobile: scrollTo", scrollObject);
        }*/


       //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        /*WebElement element = driver.findElement(By.xpath(locationCofigScreen.loc));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObjects = new HashMap();
        scrollObjects.put("element", ((RemoteWebElement) element).getId());
        scrollObjects.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObjects );*/

}