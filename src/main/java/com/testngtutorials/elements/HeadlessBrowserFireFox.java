package com.testngtutorials.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessBrowserFireFox extends AllMethods{

    FirefoxOptions firefoxoptions;
    FirefoxDriver firefoxDriver;


    @Test
    public void headlessFireFox(){

        firefoxoptions = new FirefoxOptions();
        firefoxoptions.addArguments("--headless"); //Store argument
        driver = new FirefoxDriver(firefoxoptions); //Set as a parameter in driver as a argument -> Due tp extend we can use Webdriver variable driver.
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
    }
}
