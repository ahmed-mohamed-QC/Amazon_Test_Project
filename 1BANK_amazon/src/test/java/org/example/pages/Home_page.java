package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

import static org.example.stepdefinitions.Hooks.driver;

public class Home_page {

    public WebElement Auth_page(){
        WebElement auth_page = driver.findElement(By.cssSelector("a[aria-controls=\"nav-flyout-accountList\"]"));
        return auth_page;
    }


    public WebElement TodaysDeals(){
        WebElement TodayDeals = driver.findElement(By.partialLinkText("Today's Deals"));
        return TodayDeals;
    }


    public WebElement Cart(){
        WebElement Cart = driver.findElement(By.id("nav-cart"));
        return Cart;
    }

    public void mouseHover()
    {
        WebElement element = Auth_page();
        Actions Hover = new Actions(driver);
        Hover.moveToElement(element).perform();
    }


    String selector ="ul li a span[class=\"nav-text\"]";
    List<WebElement> subcategory = driver.findElements(By.cssSelector(selector));

    public WebElement orders()
    {
        WebElement orders = subcategory.get(2);
        return orders;

    }

    public WebElement Address()
    {
        WebElement address = subcategory.get(3);
        return address;
    }

    public WebElement list()
    {
        WebElement list = subcategory.get(4);
        return list;

    }

    //


}
