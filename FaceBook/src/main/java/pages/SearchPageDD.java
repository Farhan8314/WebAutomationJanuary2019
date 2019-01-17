package pages;

import base.BrowserDriver;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pagebase.ApplicationPageBase;

public class SearchPageDD extends ApplicationPageBase {

    @FindBy
            (how = How.XPATH, xpath = "//*[@id=\"email\"]")
    WebElement enterUN;
    @FindBy(how = How.ID, id = "pass")
    WebElement enterPW;
    @FindBy(how = How.ID, id = "loginbutton")
    WebElement hitLogin;
    @FindBy(how = How.CLASS_NAME, className = "_1frb")
    WebElement enterSearch;

    public void SearchOn(String sch) {
        enterUN.click();
        enterUN.sendKeys("samadam606@yahoo.com");
        enterPW.sendKeys("bu8314");
        hitLogin.click();
        sendKeys(enterSearch,"beamer",sch);

    }

}

















