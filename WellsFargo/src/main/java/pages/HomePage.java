package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;
import application.pagebase.ApplicationPageBase;

import java.util.List;


public class HomePage extends ApplicationPageBase {

   @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Education")
    private WebElement financialEducation;

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Customer Service")
    private WebElement customerService;

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "About Wells")
    private WebElement aboutWellsFargo;

    @FindBy(how =How.CSS, css= "#userid" )
    private WebElement userid;

    @FindBy(how =How.ID, id= "password" )
    private WebElement password;

    @FindBy(how = How.ID, id = "btnSignon")
    private WebElement signOnBtn;

    @FindBy(how = How.XPATH, xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[3]/div[1]/ul[1]/li[5]/div[1]/div[1]/div[1]/img[1]")
    private WebElement todaysRates;

    @FindBy(how = How.CSS, css = "#inputTopSearchField")
    private WebElement searchButton;

    @FindBy(how = How.ID, id = "check_rates_dropdown")
    private WebElement typesOfRates;

    @FindBy(how = How.CSS, css = "#bankingTab")
    private WebElement bankingtab;

    @FindBy(how =How.PARTIAL_LINK_TEXT, partialLinkText = "Mortgage Rates")
    private WebElement mortgageSubelement;




/*    public void clickOnHomePage();*/

/*

    public void clickOnCS() {
        click(customerService, "Customer Service");
    }

    public void clickOnAbout() {
        click(aboutWellsFargo, "About Wells Fargo");
    }*/

/*   public void clickOnRates() throws InterruptedException {
       TestLogger.log("looking for rates");
       todaysRates=new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(todaysRates));
       TestLogger.log("Found rates");
       click(todaysRates, "today's rates");
    }*/


    public void clickOnRates(){
     clickOnDelayedElements(todaysRates, "Today's rates");
    }


/*
    public void clickFinancialEducation(){
        click(financialEducation, "Financial Education");

       */
/* Actions builder = new Actions(driver);
        Action action=builder.click().build();*/



public void getRates(){
    clickOnRates();
    Select select=new Select(typesOfRates);
    List<WebElement> types=select.getOptions();
    for (int x =0; x<types.size(); x++){
        System.out.println(types.get(x).getText());
    }}

public void hoverBankingAndChooseRates(){
    hoverAndClick(driver, bankingtab, mortgageSubelement, "Banking tab", "Mortgage rates subelement");
}



/*
    public void signInIDAndPw(String userId, String passWord){
        sendKeys(userid, "userid",userId);
        sendKeys(password, "password", passWord );
        click(signOnBtn, "sign-in button");

    }

    public void homePageSearch(String searches){
        sendKeys(searchButton, "search button", searches);
    }
*/



}