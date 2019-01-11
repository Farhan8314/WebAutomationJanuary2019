package test.pages;


import base.BrowserDriver;
import com.xlsx.api.MyDataReader;
import google.sheet.api.GoogleSheetReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InvalidLoginPage;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static application.pagebase.ApplicationPageBase.loadProperties;

public class HomePageTest extends BrowserDriver {

    HomePage homePage =null;
    InvalidLoginPage invalidLoginPage=null;

    @BeforeMethod
    public void initializationOfElements(){
    homePage= PageFactory.initElements(driver, HomePage.class);
    invalidLoginPage=PageFactory.initElements(driver, InvalidLoginPage.class);
    ApplicationLog.epicLogger("Elements initialized");
    }

/*

    @Test
    public void navigateToAbout(){
        homePage.clickOnAbout();
    }

    @Test
    public void navigateToCustomerService(){
        homePage.clickOnCS();
    }


    @Test
    public void test(){
        homePage.clickFinancialEducation();

    }
*/
    @Test
    public void checkTypesOfRate(){
   homePage.getRates();
}

@Test
    public void hoveroverbankingandCHoose(){
        homePage.hoverBankingAndChooseRates();
}


/*    @Test
    public void navigateToRates() throws InterruptedException {
        homePage.clickOnRates();
    }*/

    /**
     *
     * Read data from Google Sheet
     * Make sure you have created client_secret.json from your account where you have Google Sheet Data file
     * Delete .credentials directory from your module if it is exists. Other wise it will take existing/old credentials
     * thus it may give unauthorized access error(error code starting with 4, such as 403,404)
     * We can supply data to test method by two ways
     * 1. We can use @DataProvider to feed data to the test method
     * 2. We can supply data to the test method directly
     *
     * */

/*    @DataProvider(name = "googleSheet")
    public Object[][] getTestDataFromGoogleSheet() throws IOException {

        Properties properties = loadProperties();
        String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetId");
        String range = properties.getProperty("GOOGLE.range");
        *//**
         *
         * Two ways to convert  List to Array in GoogleSheetReader.java class
         * Both method will give data from Google Sheet
         *
         * *//*
         String[][] data = GoogleSheetReader.getSpreadSheetRecords(spreadsheetId, range);
        return data;

    }



    @Test(dataProvider = "googleSheet")
    public  void invalidSignin(String email, String password, String expectedErroMessage){

        objHomePage.getLogInPage();
        objLoginPage.login(email, password);
        String expectedText = expectedErroMessage;
        String actulText = objLoginPage.getErroMessage();
        Assert.assertEquals(actulText, expectedText);

    }*/

    /**
     *
     * Second way to feed data to @Test method
     * 2. We can supply data to the test method directly
     * This test is disabled if you like to run this you have to make enabled = true
     *
     * */
/*    @Test(enabled = true)
    public  void invalidSigninByGoogleSheetApi() throws IOException {

        Properties properties = loadProperties();
        String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetId");
        String range = properties.getProperty("GOOGLE.range");
        TestLogger.log("Using Sheet Number " + range.charAt(5)+ " and fields range  " + range.substring(6));
        List<List<Object>> getRecords = GoogleSheetReader.getSpreadSheetRecords(spreadsheetId,range);


        for (List cell: getRecords) {

            homePage.homePageSearch(cell.get(0).toString());

           *//* String expectedText = cell.get(2).toString();

            String actulText = objLoginPage.getErroMessage();
            Assert.assertEquals(actulText, expectedText);*//*

        }
    }*/

/*
    @DataProvider(name="DPExcel")
    public Object[][] getTestData() throws Exception{
        File filepath = new File(System.getProperty("user.dir") +  "/src/testData/TestData.xlsx");
        MyDataReader dr = new MyDataReader();

        dr.setExcelFile(filepath.getAbsolutePath());

        String[][] data = dr.getExcelSheetData("Sheet1");
        return data;
    } */



  /*  @Test(dataProvider = "DPExcel")
    public  void invalidSignIn(String userID, String passWord){
    String expectedText*//*


        homePage.signInIDAndPw(userID, passWord);}*/

/*String expected = expectedText;
        String actualText = invalidLoginPage.getInvalidErrorMessage();
        Assert.assertEquals(actualText, expected);*//*


    }

*/




}
