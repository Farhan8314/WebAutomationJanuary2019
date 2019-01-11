package pages;

import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Messenger extends BrowserDriver {

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

    enterUN.sendKeys("samadam606@yahoo.com");
     enterPW.sendKeys("bu8314");
    hitLogin.click();
     enterMessenger.click();


 }


}
