package com.testngtutorials.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FluentWaitTest extends AllMethods {
    WebDriver driver;

    WebDriverWait wait;

    @BeforeClass
    public void invokeBrowser()
    {
        driver = browserLaunchTestng();

    }

    @Test(priority = 1)
    public void fileuploadTest() {
        WebElement fu = driver.findElement(By.xpath("//a[@href='upload-download.php']"));
        //fu.click();

        //Fluent wait

        FluentWait<WebDriver> wait = new FluentWait<>(driver) //fluent wait is collection
        .withTimeout(Duration.ofSeconds(10)) // Set maximum wait time to 10 seconds
        .pollingEvery(Duration.ofMillis(500))// Check every 500 milliseconds
         .ignoring(NoSuchElementException.class)//ignore this type of exception and still execute till given time
        .withMessage("Element not found");

        //Fir Fluent Wait only
        WebElement dynamicElement;
        dynamicElement = wait.until(webDriver -> webDriver.findElement(By.id("uploadFile"))); //This -> called lamda

        assertEquals(driver.findElement(By.xpath("//Strong[text()='Select a File to Upload']")).getText(), "Select a File to Upload", "Assert Fail");
        //driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\OVI\\OneDrive\\Desktop\\TestDocument.txt");

        dynamicElement.sendKeys("C:\\Users\\OVI\\OneDrive\\Desktop\\TestDocument.txt");
    }

    //Query - click is giving warning
//    @Test(priority = 2)
//    public void dragdropnew() {
//
//        JavascriptExecutor JE = (JavascriptExecutor) driver;
//        JE.executeScript("window.scrollBy(0,5000)");
//
//        WebElement element = driver.findElement(By.xpath("//h2[@id='headingFive']/button"));
//        element.click();
//
//        driver.findElement(By.xpath("//a[@href='droppable.php']")).click();
//
//        FluentWait<WebDriver> wait = new FluentWait<>(driver); //fluent wait is collection
//        wait.withTimeout(Duration.ofSeconds(10)); // Set maximum wait time to 10 seconds
//        wait.pollingEvery(Duration.ofMillis(500)); // Check every 500 milliseconds
//
//        WebElement fluentwait_we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
//
//
//    }
}
