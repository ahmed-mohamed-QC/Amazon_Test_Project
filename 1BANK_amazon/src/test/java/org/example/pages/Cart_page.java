package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.example.stepdefinitions.Hooks.driver;

public class Cart_page {

    public WebElement expectedName(){
        WebElement expectedName = driver.findElement(By.cssSelector("div[role=\"list\"] div[role=\"listitem\"]:nth-child(2)"));
        return expectedName;
    }


    public WebElement ExpectedQuantity(){
        WebElement ExpectedQuantity = driver.findElement(By.cssSelector("span[data-a-selector=\"inner-value\"]"));
        return ExpectedQuantity;
    }




//    convert to number
public double extractPrice(String priceText) {
    return Double.parseDouble(
            priceText
                    .replace("EGP", "")
                    .replace(",", "")
                    .trim()
    );
}


    public double getcartitemprice(){
        String priceText = driver.findElement(By.cssSelector(".sc-badge-price-to-pay span.a-price span[aria-hidden='true']")).getText();
        return extractPrice(priceText);
    }



    public double SubTotal(){
        String SubTotal = driver.findElement(By.cssSelector("div[data-name='Subtotals'] span[id=\"sc-subtotal-amount-buybox\"] span.sc-price:first-of-type")).getText();
        return  extractPrice(SubTotal);
    }

    public double similarityRatio(String s1, String s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split(" ")));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split(" ")));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return (double) intersection.size() / set1.size();
    }

}
