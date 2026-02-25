package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepdefinitions.Hooks.driver;

public class item_detailes {

    public WebElement second_Cat(){
        WebElement second_Cat = driver.findElement(By.cssSelector("div[role=\"list\"] div[role=\"listitem\"]:nth-child(2)"));
        return second_Cat;
    }


    public WebElement First_prod(){
        WebElement F_prod = driver.findElement(By.xpath("(//div[@data-testid='product-card'])[1]"));
        return F_prod;
    }


    public WebElement Second_item(){
        WebElement Second_item = driver.findElement(By.cssSelector("li[data-idxintoggleswatchlist=\"1\"]"));
        return Second_item;
    }

    public WebElement ADDToCart(){
        WebElement ADDToCart = driver.findElement(By.id("add-to-cart-button"));
        return ADDToCart;
    }


    public WebElement Qlist(){
        WebElement Qlist = driver.findElement(By.id("selectQuantity"));
        return Qlist;
    }

    public List<WebElement> Quantity(){
        List<WebElement> Quantity = driver.findElements(By.cssSelector("ul[role=\"listbox\"] a"));
        return  Quantity;
    }




    public WebElement ProdName(){
        WebElement ProdName = driver.findElement(By.id("productTitle"));
        return ProdName;
    }




    //    convert to number
    public double extractNumper(String priceText) {
        return Double.parseDouble(
                priceText
                        .replace("EGP", "")
                        .replace(",", "")
                        .trim()
        );
    }


    public double ProdPrice(){
        String priceText = driver.findElement(By.cssSelector("div[id=\"corePriceDisplay_desktop_feature_div\"] span[class=\"a-price-whole\"]")).getText();
        return extractNumper(priceText);
    }






    public WebElement addcoverpopup(){
        WebElement addcover = driver.findElement(By.id("attachSiNoCoverage-announce"));
        return addcover;
    }

    public void clickIfDisplayed() {
        List<WebElement> elements = driver.findElements(By.id("attachSiNoCoverage-announce"));
        if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
            elements.get(0).click();
        }
    }

}
