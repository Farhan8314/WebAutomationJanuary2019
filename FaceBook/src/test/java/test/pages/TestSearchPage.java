/*package test.pages;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchPageDD;

public class TestSearchPage extends BrowserDriver {

    SearchPageDD searchPage= null;
    @BeforeMethod
    public void initialize(){searchPage= PageFactory.initElements(driver,SearchPageDD.class);}
    @Test
            public void navtoSearch(){searchPage.SearchOn();}


    @Test
    public void searchSql() throws Exception {

        searchPage.SearchOn();
        searchPage.searchfromdatabase();
    }








}
*/