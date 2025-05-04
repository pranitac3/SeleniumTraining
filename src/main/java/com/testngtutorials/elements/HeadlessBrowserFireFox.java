package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeadlessBrowserFireFox extends AllMethods {

    FirefoxOptions firefoxoptions;
    //driver driver;


    @BeforeClass
    public void headlessFireFox() {

        firefoxoptions = new FirefoxOptions();
        firefoxoptions.addArguments("--headless"); //Store argument
        driver = new FirefoxDriver(firefoxoptions); //Set as a parameter in driver as a argument -> Due tp extend we can use Webdriver variable driver.
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
    }

    @Test
    public void dealWithTextboxTestng() {
        enterTextTestng(driver, "id", "fullname", "Pranita");
        enterTextTestng(driver, "id", "email", "abc@abcd.com");
        enterTextTestng(driver, "id", "address", "BlueRidge IT Partk, Hinjewadi");
        //waitForSeconds(driver);
        //quitBrowser(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('password').value='passwordtext';"); //Javascript sendKeys method
        //document.getElementByID('password').value='passwordtext'; -> this is java script line
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//if Submit type

        //js.executeScript("document.argument[0].click();");  //Javascript click method

    }
}
