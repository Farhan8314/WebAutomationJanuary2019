package test.pages;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignInGoogleSheet;
import sheet.google.api.GoogleSheetReader;

import java.io.IOException;
import java.util.Properties;

import static pagebase.ApplicationPageBase.loadProperties;

public class TestSignInGoogleSheet extends BrowserDriver {
    SignInGoogleSheet signInGoogleSheet = null;

    public TestSignInGoogleSheet() throws IOException {
    }

    @BeforeMethod
    public void initialize() {
        signInGoogleSheet = PageFactory.initElements(driver, SignInGoogleSheet.class);
    }

    @DataProvider(name = "googleSheet")
    public Object[] getTestDataFromGoogleSheet() throws Exception{ Properties properties = loadProperties();
    String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetID");
    String range = properties.getProperty("GOOGLE.range");
    String[][] data = GoogleSheetReader.getSpreadSheetRecordsToSupplyDataProvider(spreadsheetId, range);
    return data;

}
        @Test(dataProvider = "googleSheet")
        public void SearchFromExcel(String un, String pw){
            signInGoogleSheet.SignOn(un, pw);






    }}



