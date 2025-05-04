package com.testngtutorials.elements;

import com.tutorialspoint.elements.AllObjectsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFileFromFirefox extends AllMethods {

    WebDriver driver;
    FirefoxProfile firefoxProfile;
    FirefoxOptions firefoxptions;

    @BeforeClass
    public void invokeFireFoxBrowser() {
        //initialization is compulsory
        firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2); // 2 means custom path
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting:", false);


        String downloadDirPath = System.getProperty("user.dir") +"\\FileUpload";
        System.out.println(downloadDirPath);
        firefoxProfile.setPreference("browser.download.dir", downloadDirPath);

        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/vnd.microsoft.icon");

        firefoxptions = new FirefoxOptions();
        firefoxptions.setProfile(firefoxProfile);
        driver = new FirefoxDriver(firefoxptions);
        System.setProperty("webdriver.gecko.driver", "C:\\AutomationSetup\\geckodriver.exe");
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.getTitle();
        driver.manage().window().maximize();


    }

//    @Test(priority = 1)
//    public void fileuploadTest() {
//        WebElement fu = driver.findElement(By.xpath("//a[@href='upload-download.php']"));
//        fu.click();
//        Assert.assertEquals("fu.getText()", "Select a File to Upload", "Assert Fail");
//        driver.findElement(By.id("uploadFile")).click();
//    }

    @Test(priority =1)
    public void downloadFile() {

        //firefoxptions = new FirefoxOptions();
        WebElement fu = driver.findElement(By.xpath("//a[@href='upload-download.php']"));
        fu.click();
        driver.findElement(By.cssSelector("#downloadButton")).click();






    }


}
