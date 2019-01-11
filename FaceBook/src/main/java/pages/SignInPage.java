package pages;


import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage extends BrowserDriver {
    @FindBy
            (how = How.XPATH, xpath = "//*[@id=\"email\"]")
    WebElement enterUN;
    @FindBy(how = How.ID, id = "pass")
    WebElement enterPW;
    @FindBy (how = How.ID, id = "loginbutton")
    WebElement hitLogin;


    public void SignOn() {
        enterUN.click();
        enterUN.sendKeys("samadam606@yahoo.oom");
        enterPW.sendKeys("bu8314");
        hitLogin.click();


    }
}