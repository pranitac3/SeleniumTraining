package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTestTestngFirefox {

    @Test
    public void firefoxInvoke()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\AutomationSetup\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.manage().window().maximize();

        driver.findElement(By.id("fullname")).sendKeys("Test Automation Firefox");
        driver.findElement(By.id("email")).sendKeys("abcdfirefox@abcd.com");
        driver.findElement(By.id("address")).sendKeys("Firefox Last priority was given to maximize window, so window was maximized as last state.Last priority was given to maximize window, so window was maximized as last state.Last priority was given to maximize window, so window was maximized as last state.");

    }
}
