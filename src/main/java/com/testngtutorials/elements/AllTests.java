package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AllTests extends AllMethods {

    WebDriver driver; //Declaration is mandatory anywhere. Where ever we are using variable we have to declare variable


    @Test
    public void alltestExecution() {

        driver = browserLaunchTestng(); //declare
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

    @Test
    public void dragdrop() {
        JavascriptExecutor JE = (JavascriptExecutor) driver;
        JE.executeScript("window.scrollBy(0,3000)");

        WebElement element = driver.findElement(By.xpath("//h2[@id='headingFive']/button"));
        //JE.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
        driver.findElement((By.xpath("//a[@href='droppable.php']"))).click();

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement((By.id("droppable")));

        Assert.assertEquals(droppable.getText(), "Drop here", "Assert fail");

        Actions actions = new Actions(driver);
        Action ac = actions.dragAndDrop(draggable, droppable).build(); //This is one more Action class. It has less methods as compare to Actions class
        ac.perform();
        Assert.assertEquals(droppable.getText(), "Dropped!", "Assert fail");
    }

    @Test
    public void fileuploadTest() {
        WebElement fu = driver.findElement(By.xpath("//a[@href='upload-download.php']"));
        fu.click();
        Assert.assertEquals("fu.getText()", "Select a File to Upload", "Assert Fail");
        driver.findElement(By.id("uploadFile")).click();
    }

}

//    //There are two ways of accessing methods
//    //-Create object
//    //-without creating object with static method
//    //Static method can be accessible with the class name without creating an object
//    //Static method belongs to class not an instance(i.e object)