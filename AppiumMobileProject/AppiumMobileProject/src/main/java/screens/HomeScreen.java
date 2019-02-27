package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen {
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    String opt="//android.widget.ImageView[contains(@resource-id,'action_bar_burger_icon')]";
    String ClickSignIn="//android.widget.TextView[contains(@resource-id,'gno_greeting_text_view')]";
    String EnterEmail="//android.widget.EditText[contains(@resource-id,'ap_email_login')]";
    String EmailContinue="//android.widget.Button[contains(@resource-id,'continue')]";
    String uncheckPwd="//android.widget.CheckBox[contains(@resource-id,'auth-signin-show-password-checkbox')]";
    String EnterPassword="//android.widget.EditText[contains(@resource-id,'ap_password')]";
    String login="//android.widget.Button[contains(@resource-id,'signInSubmit')]";
    String search="//android.widget.EditText[contains(@resource-id,'rs_search_src_text')]";
    String GoForSearch="//android.widget.LinearLayout[contains(@resource-id,'iss_search_dropdown_item_suggestions')]";

    public void SignIn(String username){
        System.out.println("Into Homescreen's searchElement SignIn method");
        click(By.xpath(opt));
        click(By.xpath(ClickSignIn));
        sendText(By.xpath(EnterEmail),username);
        click(By.xpath(EmailContinue));
        click(By.xpath(uncheckPwd));
        sendText(By.xpath(EnterPassword),"@paddu1995amazon");
        click(By.xpath(login));

    }
    public void SearchElement(String item) {
        System.out.println("Into Homescreen's searchElement method");
         sendText(By.xpath(search), item);
        }
    public void GoForSearch() {
        System.out.println("Into Homescreen's GoForSearch method");

        click(By.xpath(GoForSearch));
    }

}
