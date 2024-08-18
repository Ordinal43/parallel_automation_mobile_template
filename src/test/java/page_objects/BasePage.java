package page_objects;

import org.openqa.selenium.WebElement;

public abstract class BasePage {
    public Boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void tap(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }
}
