package com.testngtutorials.elements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name = "invokeBrowser")
    public Object[][] invokeBrowser() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}

        };
    }

    @Test(dataProvider = "invokeBrowser", dataProviderClass = DataProviderPractice.class)
    public void chromeinvoke(String chrome) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "invokeBrowser", dataProviderClass = DataProviderPractice.class)
    public void firefoxinvoke(String firefox) {
        System.setProperty("webdriver.gecko.driver", "C:\\AutomationSetup\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    }
}
