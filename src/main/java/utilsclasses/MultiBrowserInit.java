package utilsclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MultiBrowserInit {

    public WebDriver driver;

    public WebDriver invokeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\AutomationSetup\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else
        {
            System.setProperty("webdriver.edge.driver", "C:\\AutomationSetup\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        return driver;
    }

}
