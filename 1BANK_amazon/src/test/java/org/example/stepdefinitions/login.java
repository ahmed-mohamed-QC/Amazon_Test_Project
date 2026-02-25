package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home_page;
import org.example.pages.Login_page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static org.example.stepdefinitions.Hooks.wait;

public class login {

//    define home page locators
    Home_page homePage = new Home_page();

//    define Auth page locators
    Login_page loginPage =new Login_page();

    @Given("user click on Signup OR Login")
    public void userClickOnSignupORLogin() throws InterruptedException {
        homePage.Auth_page().click();
    }

    @When("user enter valid Email")
    public void userEnterValidEmail() {
        loginPage.Email().sendKeys("ahmedmohamedqc3@gmail.com");
    }

    @And("user press on continue")
    public void userPressOnContinue() {
        loginPage.ContinueBtn().click();
    }

    @Then("verify a message Looks like you're new to Amazon appears")
    public void verifyAMessageLooksLikeYouReNewToAmazonAppears() {
        SoftAssert soft =new SoftAssert();

        //1: wait until message is visible in login page!
        wait.until(ExpectedConditions.visibilityOf(loginPage.WarningMsg()));
        String actualtext =  loginPage.WarningMsg().getText();
        soft.assertTrue(actualtext.contains("Looks like you're new to Amazon"));


        //2: Create account button is visible
        wait.until(ExpectedConditions.visibilityOf(loginPage.CreateACC()));
        boolean createACC  = loginPage.CreateACC().isDisplayed();
        soft.assertTrue(createACC);





        soft.assertAll();
    }
}
