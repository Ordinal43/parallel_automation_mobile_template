package utils.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static utils.drivers.AppiumDriverInstance.getDriver;
import static utils.drivers.AppiumDriverInstance.quitDriver;

public class Hooks {
    @After
    public static void after(Scenario scenario) {
        if (getDriver() != null) {
            if (scenario.isFailed()) {
                scenario.log("Scenario failed so capturing a screenshot");

                TakesScreenshot screenshot = getDriver();
                scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
            }
            quitDriver();
        } else {
            scenario.log("Driver failed to start!");
        }
    }
}
