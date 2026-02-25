package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Cart_page;
import org.example.pages.Home_page;
import org.example.pages.item_detailes;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.example.stepdefinitions.Hooks.*;

public class add_To_Cart {

    //    define home page locators
    Home_page homePage = new Home_page();

    //    define Cart page locators
    Cart_page Cartpage = new Cart_page();

    //    define item details page locators
    item_detailes itemDetailes= new item_detailes();

    //    define item price
    private double Itemprice;

    //    define item Quantity
    public static String selectedQuantity;


    @Given("user click on Todays deals")
    public void userclickonTodaysdeals() {
        homePage.TodaysDeals().click();

    }
    @When("user Clicks on secondnd category")
    public void userClicksOnSecondndCategory() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(itemDetailes.second_Cat())).click();
        Thread.sleep(3);
    }


    @And("Click on firstst product in this category")
    public void clickOnFirststProductInThisCategory() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(itemDetailes.First_prod())).click();
        Thread.sleep(3);

    }

    @And("Click on second item in this product")

    public void clickOnSecondItemInThisProduct() throws InterruptedException {
//        driver.findElement(By.cssSelector("li[data-pagenumber=\"1\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(itemDetailes.Second_item())).click();
      Thread.sleep(3000);
        Itemprice = itemDetailes.ProdPrice();
    }

    @And("Select Quantity two")
    public void selectQuantityTwo() throws InterruptedException {
//        to open the list click on the first element
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(itemDetailes.Qlist())).click();

        Thread.sleep(2000);
        WebElement option =itemDetailes.Quantity().get(1);
        selectedQuantity = option.getText();
        option.click();
        Thread.sleep(2000);
    }



    @And("Click on add to cart")
    public void clickOnAddToCart() throws InterruptedException {


        itemDetailes.ADDToCart().click();

        By popupBtn = By.id("attachSiNoCoverage-announce");


        try {
            WebElement noCoverageBtn = wait.until(
                    ExpectedConditions.presenceOfElementLocated(popupBtn)
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", noCoverageBtn);

            System.out.println("Optional element clicked via JS");

        } catch (TimeoutException e) {
            System.out.println("Popup not shown, continue normally");
        }

        Thread.sleep(3000);
    }

    @Then("go to cart")
    public void goToCart() throws InterruptedException {
        homePage.Cart().click();

Thread.sleep(4000);
    }

    @Then("Verify correct items are added to the cart \\(name, price, qty and subtotal is correct)")
    public void verifyCorrectItemsAreAddedToTheCartNamePriceQtyAndSubtotalIsCorrect() {

        SoftAssert soft =new SoftAssert();

        System.out.println("getcartitemprice "+Cartpage.getcartitemprice());
         System.out.println("subtotal "+Cartpage.SubTotal());
//         1: assert item price in cart is same as in product details!
        soft.assertEquals(Itemprice,Cartpage.getcartitemprice());


//        2: assert quantity in cart is as added selected quantity
        soft.assertEquals(selectedQuantity,Cartpage.ExpectedQuantity().getText());

//        3: assert Subtotal in cart is item price* quantity

        soft.assertEquals(Cartpage.getcartitemprice()*2,Cartpage.SubTotal());



        soft.assertAll();

    }
}
