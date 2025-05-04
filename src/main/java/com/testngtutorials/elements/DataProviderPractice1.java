package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderPractice1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver (make sure the path to chromedriver is correct)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php"); // URL of the login page

    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderExample.class)
    public void testLogin(String username, String email, String address) {

        //Assert
        WebElement textverify = driver.findElement(By.xpath("//div//h1[text()='Selenium - Automation Practice Form']"));
        Assert.assertEquals(textverify.getText(), "Selenium - Automation Practice Form", "Verify text on landing lage");
        System.out.println("Text on landing page:" + textverify);
        // Perform login test
        WebElement usernameField = driver.findElement(By.id("fullname"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement addressField = driver.findElement(By.id("address"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        usernameField.sendKeys(username);
        emailField.sendKeys(email);
        addressField.sendKeys(address);
        submitButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
