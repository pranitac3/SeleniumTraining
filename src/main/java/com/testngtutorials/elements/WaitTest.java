package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest extends AllMethods {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void alltestExecution() {

        driver = browserLaunchTestng(); //declare
    }

    @Test
    public void fileuploadTest() {
        WebElement fu = driver.findElement(By.xpath("//a[@href='upload-download.php']"));
        fu.click();

        //Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement we_wait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadFile")));

        assertEquals(driver.findElement(By.xpath("//Strong[text()='Select a File to Upload']")).getText(), "Select a File to Upload", "Assert Fail");
        //driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\OVI\\OneDrive\\Desktop\\TestDocument.txt");

        we_wait.sendKeys("C:\\Users\\OVI\\OneDrive\\Desktop\\TestDocument.txt");
    }
}
