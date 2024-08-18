package step_definitions;

import io.cucumber.java8.En;
import page_objects.fragments.NavbarFragment;
import page_objects.pages.LoginPage;

import static org.junit.Assert.assertTrue;
import static utils.Helpers.TEST_DATA;

public class LoginSteps implements En {
    private final LoginPage loginPage;
    private final NavbarFragment navbarFragment;

    public LoginSteps() {
        this.loginPage = new LoginPage();
        this.navbarFragment = new NavbarFragment();

        Given("I am at login page", () -> {
            navbarFragment.tapEntryLogin();
            assertTrue(loginPage.isOnPage());
        });

        When("^I log in using \"([^\"]*)\" account$", (String user) -> {
            String email = TEST_DATA(String.format("%s_EMAIL", user));
            String password = TEST_DATA(String.format("%s_PASSWORD", user));
            loginPage.typeEmail(email);
            loginPage.typePassword(password);
            loginPage.tapSubmitLogin();
        });

        Then("I successfully login", () -> assertTrue(loginPage.isSuccessLogin()));
    }
}
