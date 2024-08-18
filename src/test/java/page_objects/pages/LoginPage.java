package page_objects.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePage;

import static utils.drivers.AppiumDriverInstance.getDriver;

public class LoginPage extends BasePage {
    @AndroidFindBy(accessibility = "input-email")
    private WebElement inputEmail;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement inputPassword;
    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement btnSubmitLogin;
    @AndroidFindBy(xpath = "//*[@text='You are logged in!']")
    private WebElement textSuccessLogin;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public boolean isOnPage() {
        return isDisplayed(inputEmail);
    }

    public void typeEmail(String email) {
        type(inputEmail, email);
    }

    public void typePassword(String password) {
        type(inputPassword, password);
    }

    public void tapSubmitLogin() {
        tap(btnSubmitLogin);
    }

    public boolean isSuccessLogin() {
        return isDisplayed(textSuccessLogin);
    }
}
