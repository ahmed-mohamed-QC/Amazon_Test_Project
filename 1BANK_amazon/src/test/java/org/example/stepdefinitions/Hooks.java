package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Utils.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver =null;
    public static WebDriverWait wait= null;

    @Before
    public void openBrowser(){
//   1-define property
        WebDriverManager.chromedriver().setup();
//   2-set chrome driver constructor
        driver =new ChromeDriver();
//   3-configuration
//      3.1-maximize browser
        driver.manage().window().maximize();
//      3.2-set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//      3.3-set explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//    4-navigate to url
        driver.navigate().to("https://www.amazon.eg/");

    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            ScreenShot.takeScreenshot(driver, scenario.getName());
        }

        driver.quit();
    }
}
