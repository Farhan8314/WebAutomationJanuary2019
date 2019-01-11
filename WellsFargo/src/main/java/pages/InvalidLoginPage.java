package pages;

import application.pagebase.ApplicationPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InvalidLoginPage extends ApplicationPageBase {

    @FindBy(how = How.XPATH, xpath = "//*[@id='pageerrors']/div/strong/strong")
    private WebElement errorMessage;

    public String getInvalidErrorMessage(){
        String actualText = getText(errorMessage,"errorMessage");

        return actualText;
    }


}
