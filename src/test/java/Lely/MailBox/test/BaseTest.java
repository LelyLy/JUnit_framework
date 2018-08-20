package Lely.MailBox.test;

import Lely.MailBox.pages.LoginPage;
import Lely.MailBox.pages.LogoutPage;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class BaseTest
{
    public static String browser;
    public static WebDriver driver;

    private LoginPage loginPage;
    private LogoutPage logoutPage;

    public BaseTest(String browser)
    {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Collection getBrowser()
    {
        return Arrays.asList(new Object[][]
                {
                        {"Chromedriver"}, {"Firefoxdriver"}
                });
    }

    protected WebDriver getWebdriver()
    {
        if (browser.equalsIgnoreCase("ChromeDriver"))
        {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            System.setProperty("webdriver.chrome.driver", "/home/user/Documents/chromedriver");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        else if (browser.equalsIgnoreCase("firefoxDriver"))
        {
            FirefoxProfile ffprofile = new FirefoxProfile();
            ffprofile.setPreference("dom.webnotifications.enabled", false);
            FirefoxOptions options = new FirefoxOptions().setProfile(ffprofile);
            System.setProperty("webdriver.gecko.driver", "/home/user/Documents/geckodriver");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }

        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        return driver;
    }

    public void Logout_FB() throws Exception
    {
        logoutPage.Logout_FB();
    }

    public void Logout_VK() throws Exception
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logoutPage.Logout_VK();
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}
