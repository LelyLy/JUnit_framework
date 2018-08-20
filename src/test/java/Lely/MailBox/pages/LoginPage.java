package Lely.MailBox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    @FindBy(id = "email")
    public WebElement loginfield_FB;

    @FindBy(id = "pass")
    public WebElement passfield_FB;

    @FindBy(id = "loginbutton")
    public WebElement loginbutton_FB;

    @FindBy(id = "email")
    public WebElement loginfield_VK;

    @FindBy(id = "pass")
    public WebElement passfield_VK;

    @FindBy(id = "login_button")
    public WebElement loginbutton_VK;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    public void inputLogin_FB(String login, String password) {
        loginfield_FB.sendKeys(login);
        passfield_FB.sendKeys(password);
        loginbutton_FB.click();
    }

    public void inputLogin_VK(String login, String password)
    {
        loginfield_VK.sendKeys(login);
        passfield_VK.sendKeys(password);
        loginbutton_VK.click();
    }
}
