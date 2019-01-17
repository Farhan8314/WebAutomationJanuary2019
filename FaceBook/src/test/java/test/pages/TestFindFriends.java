package test.pages;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FindFriendsPage;

public class TestFindFriends extends BrowserDriver {

FindFriendsPage findFriendsPage= null;
@BeforeMethod
    public void initialize(){ findFriendsPage= PageFactory.initElements(driver, FindFriendsPage.class);}
@Test
        public void navtoFinfFriends(){findFriendsPage.goFindFriends();

}

















}
