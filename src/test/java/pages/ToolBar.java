package pages;

import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import pages.base.BasePage;
import pages.music.MusicMainPage;

public class ToolBar extends BasePage {
    private final static By GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR =
            By.xpath("//*[@data-l='t,music']//*[@class='toolbar_nav_i_ic']");

    public MusicMainPage clickOnMusicMainPage() {
        $(GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR).click();

        return new MusicMainPage();
    }

    public UserMainPage clickOnUserMainPage() {
        //todo
        return null;
    }
}
