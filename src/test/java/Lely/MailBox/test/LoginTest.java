package Lely.MailBox.test;

import Lely.MailBox.pages.LoginPage;
import Lely.MailBox.utility.Constant;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest
{
    private LoginPage loginPage = PageFactory.initElements(getWebdriver(),LoginPage.class);

    public LoginTest(String browser)
    {
        super(browser);
    }

    @Test
    public void test_VK() throws Exception
    {
        driver.get(Constant.URL_vk);
        loginPage.inputLogin_VK(Constant.Username_vk,Constant.Password_vk);
        Logout_VK();
    }

    @Test
    public void test_FB() throws Exception
    {
        driver.get(Constant.URL_fb);
        loginPage.inputLogin_FB(Constant.Username_fb,Constant.Password_fb);
        Logout_FB();
    }
}

