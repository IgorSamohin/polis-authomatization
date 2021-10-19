package pages;

import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private final static String WELCOME_PAGE_LOG_IN_BUTTON_LOCATOR = "//*[@data-l='t,go_to_login_form']";

    private final static String LOGIN_FIELD_LOCATOR = "//*[@data-l='t,login' and @type='text']";
    private final static String PASSWORD_FIELD_LOCATOR = "//*[@data-l='t,password' and @type='password']";
    private final static String LOGIN_BUTTON_LOCATOR = "//*[@data-l='t,sign_in' and @type='submit']";


    public UserMainPage login(String login, String password) {
        SelenideElement welcomePage = $x(WELCOME_PAGE_LOG_IN_BUTTON_LOCATOR);
        if (welcomePage.isDisplayed()) {
            welcomePage.click();
        }

        $x(LOGIN_FIELD_LOCATOR).shouldBe(visible.because(IT_MUST_BE_VISIBLE_MESSAGE)).sendKeys(login);
        $x(PASSWORD_FIELD_LOCATOR).shouldBe(visible.because(IT_MUST_BE_VISIBLE_MESSAGE)).sendKeys(password);
        $x(LOGIN_BUTTON_LOCATOR).shouldBe(visible.because(IT_MUST_BE_VISIBLE_MESSAGE)).click();
        return new UserMainPage();
    }
}
