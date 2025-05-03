package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllMethods {

    WebDriver driver;

    public WebDriver browserLaunchTestng() {

        driver = new ChromeDriver();  //initialization is compulsory
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.getTitle();
        driver.manage().window().maximize();

        return driver;
    }

    public void enterTextTestng(WebDriver driver, String by, String xpath, String textvalue) {
        try {
            if (by.equalsIgnoreCase("id")) {
                driver.findElement(By.id(xpath)).sendKeys(textvalue);
            } else if (by.equalsIgnoreCase("xpath")) {
                driver.findElement(By.xpath(xpath)).sendKeys(textvalue);
            } else {
                driver.findElement(By.name(xpath)).sendKeys(textvalue);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
