package pages;

import HelperClass.ConnectToSqlDB;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pagebase.ApplicationPageBase;

import java.util.ArrayList;
import java.util.List;

public class SearchPageMysql extends ApplicationPageBase {
    @FindBy
            (how = How.XPATH, xpath = "//*[@id=\"email\"]")
    WebElement enterUN;
    @FindBy(how = How.ID, id = "pass")
    WebElement enterPW;
    @FindBy(how = How.ID, id = "loginbutton")
    WebElement hitLogin;
    @FindBy(how = How.XPATH, xpath= "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[2]")
    WebElement enterSearch;

    public void SearchOn() throws Exception {
        enterUN.click();
        enterUN.sendKeys("samadam606@yahoo.com");
        enterPW.sendKeys("bu8314");
        hitLogin.click();
    }

        List<String> glist = new ArrayList<String>();
        List<String> actual=new ArrayList<>();

        public List<String> Expected(){
            glist.add("Selenium Automation");
            glist.add("Mobile Testing");
            glist.add("Selenium Appium");
            glist.add("Desktop App Automation");
            return glist;
        }
        ConnectToSqlDB connect = new ConnectToSqlDB();
        public List<String> searchfromdatabase() throws Exception {
            Expected();

            connect.createTableFromStringToMySql("Searchitems","ItemsList");
            connect.insertDataFromArrayListToSqlTable(glist,"Searchitems","ItemsList");
          //  Actions actions = new Actions(driver);
            //actions.click(enterSearch).perform();
            List<String> data = connect.readDataBase("Searchitems","ItemsList");
            for (String items:data){
                enterSearch.sendKeys(items, Keys.ENTER);
                Thread.sleep(1000);
                enterSearch.clear();
                glist .add(items);
            }
            return actual;
        }


}
