package com.tutorialspoint.elements;

import org.openqa.selenium.WebDriver;

public class AllObjectsClass extends CommonMethods {

     static WebDriver driver; //Variable declaration

    //if we do not initialize then it will be empty variable. Nullpointer exception.

    public static void main(String[] args)  {
        AllObjectsClass allObjectsClass = new AllObjectsClass();
        //TextBox.textBox(driver); //This is for static method example
        //System.out.println(TextBox.name); //Static variable example

        driver = launchURL();
        allObjectsClass.dealWithTextbox();
        allObjectsClass.dealwithClick();
        //quitBrowser();
        //allObjectsClass.waitForSeconds(driver);

    }

    public void dealWithTextbox()  {
        enterText(AllObjectsClass.driver, "id", "fullname", "Pranita");
        enterText(AllObjectsClass.driver, "id", "email", "abc@abcd.com");
        enterText(AllObjectsClass.driver, "id", "address", "BlueRidge IT Partk, Hinjewadi");
        //waitForSeconds(driver);
        //quitBrowser(driver);

    }

    public void dealwithClick()
    {

        clickElement(driver, "xpath", "//a[@href='check-box.php']");
        clickElement(driver, "id", "c_bs_1");

        //ul[@id='navMenus']/li[2]/a
    }


}
//    //There are two ways of accessing methods
//    //-Create object
//    //-without creating object with static method
//    //Static method can be accessible with the class name without creating an object
//    //Static method belongs to class not an instance(i.e object)