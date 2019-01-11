package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BrowserDriver {


    public static ExtentReports extent;
    public static WebDriver driver = null;

    public BrowserDriver() {
    }

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(new String[]{className});
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(this.getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(this.getTime(result.getEndMillis()));
        String[] var2 = result.getMethod().getGroups();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String group = var2[var4];
            ExtentTestManager.getTest().assignCategory(new String[]{group});
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, this.getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }

        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == 2) {
            captureScreenshot(driver, result.getName());
        }

        driver.quit();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    @Parameters({"os", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("windows") String os, @Optional("10") String os_version, @Optional("chrome") String browserName, @Optional("34") String browserVersion, @Optional("https://www.facebook.com") String url) throws IOException {
        this.getLocalDriver(browserName, os);
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45L, TimeUnit.SECONDS);
        driver.get(url);
    }

    public WebDriver getLocalDriver(String browserName, String os) {
        DesiredCapabilities capabilities;
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--start-maximized"});
            options.addArguments(new String[]{"--ignore-certificate-errors"});
            options.addArguments(new String[]{"--incognito"});
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("goog:chromeOptions", options);
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\burha\\Documents\\WebAutoJan2018\\Generic\\driver\\chromedriver.exe");
                driver = new ChromeDriver(options);
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/drivers/mac/chromedriver");
                driver = new ChromeDriver(options);
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(new String[]{"--start-maximized"});
            options.addArguments(new String[]{"--ignore-certificate-errors"});
            options.addArguments(new String[]{"--private"});
            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("moz:firefoxOptions", options);
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/drivers/windows/geckodriver.exe");
                driver = new FirefoxDriver(options);
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/drivers/mac/geckodriver");
                driver = new FirefoxDriver(options);
            }
        }

        return driver;
    }

    @AfterMethod
    public void closeOut() {
        driver.quit();
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);
        File file = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception var6) {
            System.out.println("Exception while taking screenshot " + var6.getMessage());
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }
}








