import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SeleniumTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // waiting upto page load
//        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/"); // do not wait for page load

        driver.manage().window().maximize(); //to maximize window

        driver.findElement(By.id("autocomplete")).sendKeys("India" + Keys.ARROW_DOWN + Keys.ENTER); //For textbox
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //applies to all elements. Global wait
        driver.findElement(By.xpath("//input[@value='radio2']")).click(); //For radio

        driver.findElement(By.cssSelector("#checkBoxOption1")).click();  //another way of css selector xpath
        driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
        driver.findElement(By.cssSelector("#checkBoxOption3")).click();

        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByIndex(1);
        s.selectByValue("option2");
        s.selectByVisibleText("Option3");

        driver.findElement(By.id("openwindow")).click();





    }


}
