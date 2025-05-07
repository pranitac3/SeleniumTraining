package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTestTestngChrome {

    @Test(priority = 1)
    public void chromeInvoke()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("fullname")).sendKeys("Test Automation Chrome");
        driver.findElement(By.id("email")).sendKeys("abcdchrome@abcd.com");
        driver.findElement(By.id("address")).sendKeys("Chrome Last priority was given to maximize window, so window was maximized as last state.Last priority was given to maximize window, so window was maximized as last state.Last priority was given to maximize window, so window was maximized as last state.");
    }


}
