package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.UserMainPage;
import tools.Bots;

public class TestBase {
    public static final String OK_RU_URL = "https:/ok.ru";
    protected UserMainPage userMainPage;

    @BeforeEach
    public void before() {
        open(OK_RU_URL);
        Bots bot = Bots.getBot();
        LoginPage currentPage = new LoginPage();
        userMainPage = currentPage.login(bot.getLogin(), bot.getPassword());

        userMainPage.clickOnMusicMainPage().clickOnMusicMainPage();
    }

    @AfterEach
    public void after() {
        (new UserMainPage()).doLogout();
        closeWebDriver();
    }
}
