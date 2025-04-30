import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SeleniumTest {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // waiting upto page load
//        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/"); // do not wait for page load

        driver.manage().window().maximize(); //to maximize window

//        Assert.assertEquals("Verify page title", "Practice Page", driver.getTitle());
//
//        driver.findElement(By.id("autocomplete")).sendKeys("India" + Keys.ARROW_DOWN + Keys.ENTER); //For textbox
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //applies to all elements. Global wait
//        driver.findElement(By.xpath("//input[@value='radio2']")).click(); //For radio
//
//        driver.findElement(By.cssSelector("#checkBoxOption1")).click();  //another way of css selector xpath
//        driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
//        driver.findElement(By.cssSelector("#checkBoxOption3")).click();
//        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
//        s.selectByIndex(1);
//        s.selectByValue("option2");
//        s.selectByVisibleText("Option3");
//
//
//
//        String orgionalWindow = driver.getWindowHandle();
//        System.out.println(orgionalWindow);
//
//        driver.findElement(By.id("openwindow")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(driver1 -> driver1.getWindowHandles().size() >1);
//
//        for(String window: driver.getWindowHandles())
//        {
//            if(!orgionalWindow.contentEquals(window) )
//            {
//                driver.switchTo().window(window);
//                Assert.assertEquals("info@qaclickacademy.com", driver.findElement(By.xpath("(//span[text()='info@qaclickacademy.com'])[1]")).getText());
//
//            }
//
//        }
//        driver.switchTo().window(orgionalWindow);
//
//        //driver.findElement(By.id("opentab")).click();
//
//        driver.findElement(By.id("name")).sendKeys("Pranita");
//        driver.findElement(By.id("alertbtn")).click();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();
//
//        driver.findElement(By.id("confirmbtn")).click();
//        Alert alertconfirm = driver.switchTo().alert(); //Every time create object and use that object ahead ex: getText()
//        System.out.println(alertconfirm.getText());
//
//        driver.navigate().forward(); //Browser forward  , abackward
//        driver.navigate().back();
//        //System.out.println(driver.getPageSource();
//        System.out.println(driver.getCurrentUrl()); //To get current url
//
//        //System.out.println(driver.switchTo().alert().getText());
//
//        //driver.close(); //current window close
//        driver.quit(); //closes all instances of window opened by current driver.


//        TakesScreenshot ts = (TakesScreenshot) driver; //This is interface but this does not have any class
//        File source = ts.getScreenshotAs(OutputType.FILE); //This is source file
//        String screenshotName = "./screenshots/" + result.getName() + ".png";
//        FileUtils.copyFile(source, new File(screenshotName));//FileUtils is class.
//        System.out.println("Screenshot taken for failed test: " + result.getName());

        //File is present in java.io
        // driver convert into Takescreenshot. Typecast doing
        TakesScreenshot TS = (TakesScreenshot)driver; //This is interface but this does not have any class
        File srcFile = TS.getScreenshotAs(OutputType.FILE); //This is source file
        //String screenshotName = "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\Screenshots\\" + srcFile.getName() + ".png";

        //File destFile = new File("C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\Screenshots\\"+TS+".jpg");



        String TimeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        FileUtils.copyFile(srcFile, new File("Screenshots//"+ TimeStamp +".jpg"));
        //FileHandler.copy(srcFile, new File(screenshotName));
        System.out.println("Screenshot taken for test: " + srcFile.getName());




        //--------------Hide Show textbox--------
        //WebElement sideshow = driver.findElement(By.id("displayed-text"));
        //sideshow.isDisplayed();


        driver.findElement(By.id("hide-textbox")).click();
        boolean hideshowtb = driver.findElement(By.id("displayed-text")).isDisplayed();
        if (hideshowtb)
        {
            System.out.println(hideshowtb);
            //Assert.assertTrue("Displayed", hideshowtb);
        }
        else {

            System.out.println(hideshowtb);
            //Assert.assertTrue("Displayed", hideshowtb);
            //Assert.assertFalse("false condititon satisfied", hideshowtb);
        }


//



        WebElement hideshowtb1  = driver.findElement(By.id("displayed-text"));
        //hideshowtb1.isDisplayed();
        //hideshowtb1.sendKeys("Pranita");

        //---------Scroll Down using JS Executor-------------
        JavascriptExecutor JE = (JavascriptExecutor) driver;
        JE.executeScript("window.scrollBy(0,1000)");

        //---------iFrame----------

        driver.switchTo().frame("courses-iframe");
        String iframeText = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/h2/span/strong")).getText();
        System.out.println(iframeText);


        //Assert.assertEquals("Expected and Actual text both are matching", "Learn Earn & Shine", iframeText);

        //This can be used for error message
        Assert.assertEquals("Expected and Actual text does not match the value", "Learn Earn & Shine1", iframeText);
        //Here if condition is matched then it will not return anything, but if condition is false then it will show message


        //Assert.assertEquals("Verify page title", "Learn Earn & Shine", driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/h2/span/strong"));



        driver.quit();
    }

}
