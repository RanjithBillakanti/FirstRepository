package tests.cucumber.StepDefin;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.Base.BaseUtil;
import tests.ThreadLocalDriver;
import tests.cucumber.Transformer.EmailTransformer;

import java.util.List;


public class MyStepdef extends BaseSteps {

    BaseUtil baseUtil=new BaseUtil();

    public MyStepdef(BaseUtil baseUtil){
        this.baseUtil=baseUtil;
    }

    @Before
    public void setupLoginSteps() {
        System.out.println("Cucumber Before-login-test-cucumber");
          setupCucumber();
    }


    @Given("^I have skipped Splashscreen$")
    public void iHaveSkippedSplashscreen() throws Throwable {
        System.out.println("Baseutil is set to :" +baseUtil.stepInfo);


        System.out.println("skip signIn");
        System.out.println(baseUtil.stepInfo);
        splashScreen.skipSplashScreen();
    }


    /*@Then("^I sign in to my account$")
    public void iSignInToMyAccount() throws Throwable {
        System.out.println("signIn to amazon");
        homeScreen.SignIn();
    }*/



    /*@And("^search for an item$")
    public void searchForAnItem() throws Throwable {
        homeScreen.SearchElement();
        homeScreen.GoForSearch();
    }
*/

    @Then("^I select the item$")
    public void iSelectTheItem() throws Throwable {
        productListScreen.SelectElement();
    }

    @Then("^I add it to cart$")
    public void iAddItToCart() throws Throwable {

        productDetailScreen.AddingToCart();
        locationCofigScreen.checkIfLocationPopUp_Enterpin();
        locationCofigScreen.checkIfLocationPopUp_useMyLoc();
        System.out.println("The product is added to cart");

    }

    @Then("^I sign in to my account as ([^\"]*)$")
    public void iSignInToMyAccountAsPadmashreekamal(@Transform(EmailTransformer.class) String username) throws Throwable {
        System.out.println("signIn to amazon");
        homeScreen.SignIn(username);
    }

    @And("^I delete item from cart$")
    public void iDeleteItemFromCart() throws Throwable {
        myCartScreen.DeleteFromCart();

    }

    @And("^search for item$")
    public void searchForItem(DataTable table) throws Throwable {
        List<List<String>> data=table.raw();
        String item=data.get(0).get(0);
        System.out.println(item);
        homeScreen.SearchElement(item);
        homeScreen.GoForSearch();
    }

   /* @And("^search for <item>$")
    public void searchForItem(DataTable table) throws Throwable {
        List<List<String>> data=table.raw();
        String item=data.get(0).get(0);
        System.out.println(item);
        homeScreen.SearchElement(item);
        homeScreen.GoForSearch();
    }*/

 /*   @Then("^I add it to cart \"([^\"]*)\"$")
    public void iAddItToCart(String Value) throws Throwable {
        String VAL=Value;
       Testt.craete(VAL);


    }*/
}


