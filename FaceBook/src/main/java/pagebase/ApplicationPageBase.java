package pagebase;

import base.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class ApplicationPageBase extends BrowserDriver {

    String pageUrl;



    //return status of link if it is enabled
    public static boolean isEnableStatus(WebDriver driver, WebElement web) {
        boolean en = web.isEnabled();
        return en;
    }
    public static void hoverAndClick(WebDriver driver, WebElement webElement, WebElement webElement2, String webElementName, String webElementName2){
        Actions actions= new Actions(driver);
        clickOnDelayedElements(webElement,"is clickable");
        actions.moveToElement(webElement).perform();
        TestLogger.log("Hovered over "+ webElementName);
        webElement2.click();
        TestLogger.log("clicked on " + webElementName2);
    }

    public static void sendKeys(WebElement webElement, String webElementName, String keys){
        webElement.clear();
        TestLogger.log("Sending " + keys + " to " + webElementName);
        webElement.sendKeys(keys);
        TestLogger.log("Keys Sent to " + webElementName);
    }

    public static String getText(WebElement webElement, String webElementName){

        TestLogger.log("Getting Text from " + webElementName);
        String actualText =  webElement.getText();
        TestLogger.log("Actual text: " + actualText);

        return actualText;

    }
    public static void click(WebElement webElement, String webElementName){
        TestLogger.log("Click " + webElementName );
        webElement.click();
        TestLogger.log("Clicked " + webElementName);
    }
    public static void clickOnDelayedElements(WebElement webElement, String webElementName){
        TestLogger.log("looking for " + webElementName );
        long time= System.currentTimeMillis();
        webElement =new WebDriverWait(driver, 24).until(ExpectedConditions.elementToBeClickable(webElement));
        TestLogger.log("Found element after waiting");
        webElement.click();
        long timeittook=System.currentTimeMillis()-time;
        TestLogger.log("Clicked " + webElementName + "after waiting " + timeittook + "ms");
    }
    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        File filepath = new File(System.getProperty("user.dir") +  "/src/test/resources/secret.properties");
        InputStream ism = new FileInputStream(filepath.getAbsoluteFile());
        prop.load(ism);
        ism.close();
        return prop;
    }

}



