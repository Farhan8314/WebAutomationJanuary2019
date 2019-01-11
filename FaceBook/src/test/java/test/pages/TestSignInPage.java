package test.pages;


import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignInPage;
import util.xls.reader.test.MyDataReader;

import java.io.File;

public class TestSignInPage extends BrowserDriver {

    SignInPage signIntoFaceBook = null;

    @BeforeMethod
    public void initialize() {
        signIntoFaceBook = PageFactory.initElements(driver, SignInPage.class);
    }

    @Test
    public void SignintoPro() {
        signIntoFaceBook.SignOn("samadam606@yahoo.com", "bu8314");
    }

    @DataProvider(name = "DPExcel")
    public Object[][] getTestData() throws Exception {
        File filepath = new File(System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx");
        MyDataReader dr = new MyDataReader();

        dr.setExcelFile(filepath.getAbsolutePath());

        String[][] data = dr.getExcelSheetData("Sheet1");
        return data;
    }


    @Test(dataProvider = "DPExcel")
    public  void invalidSignIn(String userID, String passWord){
        signIntoFaceBook.SignOn(userID, passWord);}
}
