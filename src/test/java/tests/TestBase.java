package tests;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.SelenideConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.UserMainPage;
import tools.Bots;

public class TestBase {
    public static final String OK_RU_URL = "https:/ok.ru";

    @BeforeEach
    public void before() {
        Configuration.startMaximized = true;
        open(OK_RU_URL);
        Bots bot = Bots.getBot();
        LoginPage currentPage = new LoginPage();
        currentPage.login(bot.getLogin(), bot.getPassword());
    }

    @AfterEach
    public void after() {
        open(OK_RU_URL);
        (new UserMainPage()).doLogout();
        closeWebDriver();
    }
}
