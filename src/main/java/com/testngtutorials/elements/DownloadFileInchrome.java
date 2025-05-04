package com.testngtutorials.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DownloadFileInchrome {

    WebDriver driver;
    ChromeOptions chromeoptions = new ChromeOptions();
    String downloadDir = "FileUpload//";
    Map<String, Object> prefs = new HashMap<>();

    @BeforeClass
    public void invokeChrome(){

        //chromeoptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php"); // waiting upto page load
        driver.manage().window().maximize(); //to maximize window
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");

    }

    @Test
    public void FileDownloadInChrome(){


        WebElement fu = driver.findElement(By.xpath("//a[@href='upload-download.php']"));
        fu.click();
//      driver.findElement(By.cssSelector("#downloadButton")).click();
//      chromeoptions.addArguments("download.default_directory", downloadDir);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        chromeoptions = new ChromeOptions();
        chromeoptions.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(chromeoptions);




    }
}
