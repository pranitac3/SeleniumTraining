package com.testngtutorials.elements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class DataProviderPractice1 {

    WebDriver driver;

    //Login Test - data provider working - But need to ask about 'how to take screenshot after each test"

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver (make sure the path to chromedriver is correct)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php"); // URL of the login page

    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderPractice1Example.class)
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

    @AfterSuite
    public void takeScreenshots() throws IOException {
        TakesScreenshot TS = (TakesScreenshot) driver; //This is interface but this does not have any class
        File srcFile = TS.getScreenshotAs(OutputType.FILE); //This is source file

        String TimeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        FileUtils.copyFile(srcFile, new File("Screenshots//"+ TimeStamp +".jpg"));

        //String screenshotName = "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\Screenshots\\" + srcFile.getName() + ".png"
        //FileHandler.copy(srcFile, new File(screenshotName));

        System.out.println("Screenshot taken for test: " + srcFile.getName());

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
