/*package test.pages;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchPageDD;
import util.xls.reader.test.MyDataReader;

import java.io.File;

public class TestSearchDD extends BrowserDriver {
    SearchPageDD searchPageDD=null;
    @BeforeMethod
    public void initialize() {searchPageDD = PageFactory.initElements(driver,SearchPageDD.class); }
@Test
    public void enterSearchin(){searchPageDD.SearchOn("BMW");}
     @DataProvider (name = "Excel")
    public Object [][] testdata() throws Exception {
         File file = new File(System.getProperty("user-dir") + "\\src\\test\\resources\\TestData.xlsx");
         // MyDataReader
     }


}*/
