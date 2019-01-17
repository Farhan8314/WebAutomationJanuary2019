package pages;

import HelperClass.ConnectToSqlDB;
import base.BrowserDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pagebase.ApplicationPageBase;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

public class Messenger extends ApplicationPageBase {

     @FindBy(how = How.XPATH, xpath = "//*[@id=\"email\"]")
    WebElement enterUN;
    @FindBy(how = How.ID, id = "pass")
    WebElement enterPW;
    @FindBy(how = How.ID, id = "loginbutton")
    WebElement hitLogin;
    @FindBy(how = How.XPATH, xpath = "//a[@title='Messenger']")
    WebElement enterMessenger;

    public void gotoMessenger() {
        sendKeys(enterUN, "username", "samadam606@yahoo.com");
        sendKeys(enterPW, "password", "bu8314");
        click(hitLogin, "login");
        TestLogger.log("signed in succesfully");
        click(enterMessenger, "messenger");


    }


}