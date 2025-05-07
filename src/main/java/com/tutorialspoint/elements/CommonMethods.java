package com.tutorialspoint.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.tutorialspoint.elements.AllObjectsClass.driver;


public class CommonMethods
{

        static WebDriver driver ;

    //--------------Launching Browser/URL--------------------
    public static WebDriver launchURL()
    {

        driver = new ChromeDriver();  //initialization is compulsory
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.getTitle();
        driver.manage().window().maximize();

         return driver;

    }
    //--------------Enter text--------------------
    public void enterText(WebDriver driver, String by, String xpath, String textvalue)
    {
        try {
            if (by.equalsIgnoreCase("id"))
            {
                driver.findElement(By.id(xpath)).sendKeys(textvalue);
            }
            else if (by.equalsIgnoreCase("xpath"))
            {
                driver.findElement(By.xpath(xpath)).sendKeys(textvalue);
            }
            else
            {
                driver.findElement(By.name(xpath)).sendKeys(textvalue);
            }
        } catch (Exception e)
    {
            throw new RuntimeException(e);
       }
    }

    //--------------Checkbox--------------------
    public void clickElement(WebDriver driver, String clickby , String clickxpath)
    {
        if(clickby.equalsIgnoreCase("id"))
        {
            driver.findElement(By.id(clickxpath)).click();
        }
        else if (clickby.equalsIgnoreCase("xpath"))
        {
            driver.findElement(By.xpath(clickxpath)).click();
        }
        else
        {
            driver.findElement(By.name(clickxpath)).click();
        }
    }

    //--------------Quit Browser--------------------
    public static void quitBrowser()
    {
        driver.quit();
    }

    //--------------waitForSeconds--------------------
    public void waitForSeconds(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
