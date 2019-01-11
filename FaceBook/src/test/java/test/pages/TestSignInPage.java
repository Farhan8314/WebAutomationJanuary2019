package test.pages;


import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

public class TestSignInPage extends BrowserDriver {

    SignInPage signIntoFaceBook = null;
    @BeforeMethod
    public void initialize (){signIntoFaceBook = PageFactory.initElements(driver, SignInPage.class);}

    @Test
    public void SignintoPro(){ signIntoFaceBook.SignOn();}}









