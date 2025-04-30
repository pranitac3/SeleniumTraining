
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MouseHover {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // waiting upto page load
//        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/"); // do not wait for page load

        driver.manage().window().maximize();

        //---------Scroll Down using JS Executor-------------
        JavascriptExecutor JE = (JavascriptExecutor) driver;
        JE.executeScript("window.scrollBy(0,1000)");

        driver.switchTo().frame("courses-iframe");


        driver.findElement(By.id("mousehover")).click();
        WebElement mh = driver.findElement(By.xpath("//a[@href='#top']"));
        Actions action = new Actions(driver);
        action.moveToElement(mh).click().build().perform();


    }


    }