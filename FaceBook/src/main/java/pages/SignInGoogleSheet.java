package pages;

import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pagebase.ApplicationPageBase;

public class SignInGoogleSheet extends ApplicationPageBase {
    @FindBy
            (how = How.XPATH, xpath = "//*[@id=\"email\"]")
    WebElement enterUN;
    @FindBy(how = How.ID, id = "pass")
    WebElement enterPW;
    @FindBy(how = How.ID, id = "loginbutton")
    WebElement hitLogin;


    public void SignOn(String un, String pw) {
        enterUN.click();
        sendKeys(enterUN, "username", un);
        sendKeys(enterPW, "passward", pw);
        hitLogin.click();


    }
}