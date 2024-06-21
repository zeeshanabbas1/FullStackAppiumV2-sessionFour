package testCases;

import base.AppFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends AppFactory {


    LoginPage loginPage;
    ProductPage productPage;
    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage();
        productPage = new ProductPage();

    }


    @Test
    public void verifyValidUserLogin() {
        loginPage.enterValidUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        String actualProductTitle = productPage.getTitle();
        String expectedProductTitle = "PRODUCTS";
        System.out.println("Actual Product page title is - " + actualProductTitle + "\n" + "Expected Product page title is - " + expectedProductTitle);
        Assert.assertEquals(actualProductTitle, expectedProductTitle);

        System.out.println("Logged in");

    }

    @AfterMethod
    public void tearDown() {
        AppFactory.quitDriver();
    }


}
