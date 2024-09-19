package utils.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static utils.Helpers.ENV;

public class AppiumDriverInstance {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            UiAutomator2Options caps = new UiAutomator2Options();
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("app", ENV("APP_PATH"));
            caps.setCapability("autoGrantPermissions", true);
            caps.setCapability("disableWindowAnimation", true);
            caps.setCapability("hideKeyboard", true);

            try {
                driver = new AppiumDriver(new URL(ENV("APPIUM_URL")), caps);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (MalformedURLException e) {
                System.out.println("Appium Driver not started");
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
