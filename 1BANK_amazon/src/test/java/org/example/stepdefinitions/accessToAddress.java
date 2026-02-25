package org.example.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home_page;
import org.testng.asserts.SoftAssert;

import static org.example.stepdefinitions.Hooks.*;

public class accessToAddress {

    //define home page locators
    Home_page homePage = new Home_page();
    SoftAssert soft =new SoftAssert();



    //First Scenario
    @Given("user hovers on Hello")
    public void userhoversonHello() throws InterruptedException {

        homePage.mouseHover();
        Thread.sleep(3000);
    }

    @When("user selects Your Orders")
    public void userSelectsYourOrders() {
        homePage.orders().click();
    }

    @Then("user should be redirected to sign in page")
    public void userShouldBeRedirectedToSignInPage() throws InterruptedException {
        String actualUrl =  driver.getCurrentUrl();
        soft.assertTrue(actualUrl.contains("signin"));
        Thread.sleep(2000);
    }


    //Second Scenario
    @Given("user hovers on Hello, sign in Account & Lists")
    public void userHoversOnHelloSignInAccountLists() throws InterruptedException {
        homePage.mouseHover();
        Thread.sleep(4000);
    }

    @When("user selects Your Addresses")
    public void userSelectsYourAddresses() {
        homePage.Address().click();
    }
    @Then("user should be redirected to sign in")
    public void usershouldberedirectedtosignin() throws InterruptedException {
        String actualUrl =  driver.getCurrentUrl();
        soft.assertTrue(actualUrl.contains("signin"));
        Thread.sleep(4000);

    }


    //Last Scenario
    @Given("user hovers on Hello, sign in Account")
    public void userHoversOnHelloSignInAccount() {
        homePage.mouseHover();
    }

    @When("user selects Your Lists")
    public void userSelectsYourLists() {
        homePage.list().click();
    }

    @Then("Your Lists intro screen should be displayed")
    public void yourListsIntroScreenShouldBeDisplayed() throws InterruptedException {
        String actualUrl =  driver.getCurrentUrl();
        soft.assertTrue(actualUrl.contains("wishlist/intro"));
        Thread.sleep(4000);

    }
}
