package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepdefinitions.Hooks.driver;

public class Login_page {

    public WebElement Email(){
        WebElement Email_field = driver.findElement(By.id("ap_email_login"));
        return Email_field;
    }

//
//
//    public WebElement Password(){
//        WebElement Password_field = driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]"));
//        return Password_field;
//    }

    public WebElement ContinueBtn(){
        WebElement Continue = driver.findElement(By.className("a-button-input"));
        return Continue;
    }


    public WebElement WarningMsg(){
        WebElement Warning = driver.findElement(By.cssSelector(".a-size-medium-plus"));
        return Warning;
    }

    public WebElement CreateACC(){
        WebElement CreateACC = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        return CreateACC;
    }

}
