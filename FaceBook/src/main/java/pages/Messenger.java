package pages;

import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pagebase.ApplicationPageBase;
import reporting.TestLogger;

public class Messenger extends ApplicationPageBase {

    @FindBy
            (how = How.XPATH, xpath = "//*[@id=\"email\"]")
    WebElement enterUN;
    @FindBy(how = How.ID, id = "pass")
    WebElement enterPW;
    @FindBy (how = How.ID, id = "loginbutton")
    WebElement hitLogin;
    @FindBy
            (how = How.XPATH, xpath = "//a[@title='Messenger']")

    WebElement enterMessenger;
 public void gotoMessenger(){

   sendKeys(enterUN, "username", "samadam606@yahoo.com");
    sendKeys(enterPW,"password","bu8314");
   click(hitLogin,"login");
     TestLogger.log("signed in succesfully");
    click(enterMessenger, "messenger");



 }


}
