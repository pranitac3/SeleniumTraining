package utilsclasses;

import org.openqa.selenium.chrome.ChromeDriver;


public class InitiateBrowser {

    public void initialization(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // waiting upto page load

    }

}
