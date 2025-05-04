package com.testngtutorials.elements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ScreenshotPractice {

    WebDriver driver;
    @BeforeClass
    public void chromeinvoke() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void assertAndPrintText()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement textverify = driver.findElement(By.xpath("//div//h1[text()='Selenium - Automation Practice Form']"));
        System.out.println("Text on landing page:" + textverify);
        Assert.assertEquals(textverify.getText(), "Selenium - Automation Practice Form", "Verify text on landing lage");

    }
    @Test(priority =  2)
    public void takeScreenshots() throws IOException {
        TakesScreenshot TS = (TakesScreenshot) driver; //This is interface but this does not have any class
        File srcFile = TS.getScreenshotAs(OutputType.FILE); //This is source file

        String TimeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        FileUtils.copyFile(srcFile, new File("Screenshots//"+ TimeStamp +".jpg"));

        //String screenshotName = "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\Screenshots\\" + srcFile.getName() + ".png"
        //FileHandler.copy(srcFile, new File(screenshotName));

        System.out.println("Screenshot taken for test: " + srcFile.getName());

    }
}
