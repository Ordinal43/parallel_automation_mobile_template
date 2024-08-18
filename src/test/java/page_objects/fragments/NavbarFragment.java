package page_objects.fragments;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePage;

import static utils.drivers.AppiumDriverInstance.getDriver;

public class NavbarFragment extends BasePage {
    @AndroidFindBy(accessibility = "Login")
    private WebElement btnEntryLogin;

    public NavbarFragment() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public void tapEntryLogin() {
        tap(btnEntryLogin);
    }
}
