package Lely.MailBox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LogoutPage extends BasePage
{
    public LogoutPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "userNavigationLabel")
    private WebElement userNavigationLabel_FB;

    @FindBy(xpath = "//li[12]/a/span/span")
    private WebElement buttonLogout_FB;

    @FindBy(id = "top_profile_link")
    private WebElement userNavigation_VK;

    @FindBy(id= "top_logout_link")
    private WebElement buttonLogout_VK;

    public  void Logout_FB()
    {
        userNavigationLabel_FB.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonLogout_FB.click();
    }

    public  void Logout_VK()
    {
        userNavigation_VK.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        buttonLogout_VK.click();
    }

}
