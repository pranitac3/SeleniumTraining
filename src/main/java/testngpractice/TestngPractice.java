package testngpractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import utilsclasses.InitiateBrowser;  //

public class TestngPractice{


     public WebDriver driver; //default access modifier.


    //------------Initialize browser------------
    @BeforeTest()
    public void InitializeBrowser() {

        InitiateBrowser init = new InitiateBrowser();
        driver = init.initialization();

//        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        System.out.println("driver is initialized");
    }

    @AfterTest()
    public void quit()
    {
        driver.quit();
        System.out.println("all windows opened by driver all closed.");
    }

    //------------Maximize Window------------
    @Test(priority = 1)
    public void maximizeWindow()
    {
        driver.manage().window().maximize();
        System.out.println("Window is maximized");
    }

    //------------Take Screenshot------------
    @Test (priority = 2)
    public void takeScreenshot() throws IOException {
        TakesScreenshot TS = (TakesScreenshot) driver; //This is interface but this does not have any class
        File srcFile = TS.getScreenshotAs(OutputType.FILE); //This is source file

        Date date = new Date(); //normal object create
        String TimeStamp = new SimpleDateFormat("dd-M-yyyyhhmmss").format(date);
        //String TimeStamp = new SimpleDateFormat("dd-M-yyyyhhmmss").format(new Date());//inline object create

        String descFile = "Screenshots//"+ TimeStamp +".jpg";
        File file = new File(descFile);
        FileUtils.copyFile(srcFile,file);

        System.out.println("Screenshot taken for test: " + file.getName());
        System.out.println(file.getAbsolutePath());
    }

    //------------Assert Test------------
    @Test (priority = 3)
    public void assertTest()
    {
        Assert.assertEquals(driver.getTitle(), "Practice Page"); //In testng Verify message is not there
        System.out.println("assert test PASS");
    }

    //------------Radio Button Test------------
    @Test (priority = 4)
    public void radioButtonTest()
    {
        driver.findElement(By.id("autocomplete")).sendKeys("India" + Keys.ARROW_DOWN + Keys.ENTER); //For textbox
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //applies to all elements. Global wait
        driver.findElement(By.xpath("//input[@value='radio2']")).click(); //For radio
        System.out.println("Radio button test pass");
    }

    //------------Checkbox Test------------
    @Test (priority = 5)
    public void checkBoxTest()
    {

        driver.findElement(By.cssSelector("#checkBoxOption1")).click();  //another way of css selector xpath
        driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
        driver.findElement(By.cssSelector("#checkBoxOption3")).click();
        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByIndex(1);
        s.selectByValue("option2");
       s.selectByVisibleText("Option3");
        System.out.println("Checkbox button test pass");
    }

    //-------------------Alert Check-----------------
    @Test(priority = 6)
    public void alertCheck()
    {
        driver.findElement(By.id("name")).sendKeys("Pranita");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println("Alert text1: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("confirmbtn")).click();
        Alert alertconfirm = driver.switchTo().alert(); //Every time create object and use that object ahead ex: getText()
        System.out.println("Alert text2: " +alertconfirm.getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    ////------------iframe Test------------
    @Test (priority = 7)
    public void switchToFrame()
    {
        //---------Scroll Down using JS Executor-------------
        JavascriptExecutor JE = (JavascriptExecutor) driver;
        JE.executeScript("window.scrollBy(0,1000)");
        //Switch to frame
        driver.switchTo().frame("courses-iframe");
        String iframeText = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/h2/span/strong")).getText();
        System.out.println(iframeText);
        System.out.println("SwitchTo frame executed");

    }



}