package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;
import pages.music.MusicMainPage;

public class ToolBar extends BasePage {
    private final static String GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR = "//*[@data-l='t,music']//*[@class='toolbar_nav_i_ic']";

    private final static String U_CARD_MINI = "//*[contains(@class, 'toolbar_ucard')]";
    private final static String LOG_OUT_BUTTON_IN_U_CARD_MINI = "//*[@data-l='t,logoutCurrentUser']";
    private final static String LOG_OUT_SUBMIT_BUTTON = "//*[@data-l='t,logout' and @type='submit']";

    private final static String LOGO_BUTTON_LOCATOR = "//*[@data-l='t,logo']";

    public MusicMainPage clickOnMusicMainPage() {
        $x(GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR).click();

        return new MusicMainPage();
    }

    public UserMainPage clickOnUserMainPage() {
        $x(LOGO_BUTTON_LOCATOR).shouldBe(visible.because(IT_MUST_BE_VISIBLE_MESSAGE)).click();
        return new UserMainPage();
    }

    public LoginPage doLogout() {
        $x(U_CARD_MINI).shouldBe(visible.because(IT_MUST_BE_VISIBLE_MESSAGE)).click();
        $x(LOG_OUT_BUTTON_IN_U_CARD_MINI).shouldBe(visible.because(IT_MUST_BE_VISIBLE_MESSAGE)).click();
        SelenideElement confirmPopUp = $x(LOG_OUT_SUBMIT_BUTTON);
        if (confirmPopUp.isDisplayed()) {
            confirmPopUp.click();
        }
        return new LoginPage();
    }
}
