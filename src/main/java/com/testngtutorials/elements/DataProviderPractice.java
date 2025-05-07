package com.testngtutorials.elements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    //Browser invoke - Need to ask savi

    @DataProvider(name = "invokeBrowser")
    public Object[][] invokeBrowser() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}

        };
    }

    @Test(dataProvider = "invokeBrowser", dataProviderClass = DataProviderPractice.class)
    public void chromeinvoke(String browserName)
    {
        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            driver.manage().window().maximize();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver", "C:\\AutomationSetup\\geckodriver.exe");
            FirefoxDriver driver = new FirefoxDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            driver.manage().window().maximize();
        }
    }

    }
