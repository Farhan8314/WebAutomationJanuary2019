package test.pages;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPageMysql;
import pages.SignInGoogleSheet;

public class TestSearMysql extends BrowserDriver {


    SearchPageMysql searchPageMysql=null;
    @BeforeMethod
    public void initialize (){searchPageMysql= PageFactory.initElements(driver, SearchPageMysql.class);}
@Test
public void navSearch() throws Exception {searchPageMysql.SearchOn();}
   @Test
    public void EnterFromDb() throws Exception {searchPageMysql.SearchOn();searchPageMysql.searchfromdatabase();








}}
