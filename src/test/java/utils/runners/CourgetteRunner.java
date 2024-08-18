package utils.runners;

import courgette.api.*;
import courgette.api.junit.Courgette;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        reportTargetDir = "build",
        testOutput = CourgetteTestOutput.CONSOLE,
        disableHtmlReport = HtmlReport.COURGETTE_AND_CUCUMBER_HTML,
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = {"step_definitions", "utils.hooks"},
                plugin = {
                        "pretty",
                        "json:build/cucumber.json",
                        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                }
        ))
public class CourgetteRunner {
}
