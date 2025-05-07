//package com.tutorialspoint.elements;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LaunchURL  {
//
////    static WebDriver driver; //Variable declaration
////    //if we do not initialize then it will be empty variable. Nullpointer exception.
////
////    public static void main(String[] args) throws InterruptedException {
////        LaunchURL launchURLObj = new LaunchURL();
////        launchURLObj.url();
////        TextBox.textBox(driver); //This is for static method example
////        System.out.println(TextBox.name); //Static variable example
////        launchURLObj.dealWithTextbox();
////        launchURLObj.quitBrowser(driver);
////        launchURLObj.waitForSeconds(driver);
////    }
//
//
//    public void url(WebDriver driver) {
//
//        driver = new ChromeDriver();  //initialization is compulsory
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OVI\\OneDrive\\Desktop\\SeleniumTraining\\chromedriver-win64\\chromedriver.exe");
//        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
//        driver.getTitle();
//        driver.manage().window().maximize();
//
//    }
//
//
//
//
//
//    //There are two ways of accessing methods
//    //-Create object
//    //-without creating object with static method
//    //Static method can be accessible with the class name without creating an object
//    //Static method belongs to class not an instance(i.e object)
//}
//
