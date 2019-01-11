package test.pages;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Messenger;

public class TestMessenger extends BrowserDriver {
    Messenger messenger = null;

    @BeforeMethod
    public void intialize() {
        messenger = PageFactory.initElements(driver, Messenger.class);
    }
        @Test



        public void navtoMessenger () {

            messenger.gotoMessenger();
        }


    }
