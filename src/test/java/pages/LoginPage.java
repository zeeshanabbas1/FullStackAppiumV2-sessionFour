package pages;

import base.AppDriver;
import base.AppFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends AppFactory {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "test-Username")
    public WebElement userNameTextBox;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passordTextBox;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;

    By swagLabsHeader = By.xpath("//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]");

    public void enterValidUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20));
       //.until(ExpectedCondition.visibilityOfAllElementLocatedBy(swagLabsHeader));
        List<WebElement> header = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(swagLabsHeader));
        userNameTextBox.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passordTextBox.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }


}
