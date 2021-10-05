package pages;

import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;

public class ToolBar {

    private final By GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR = By.xpath("//*[@class='toolbar_nav']//*[@data-l='t,music']");

    public MusicMainPage clickOnMusicMainPage() {
        $(GO_TO_MUSIC_MAIN_PAGE_BUTTON_LOCATOR).click();

        return new MusicMainPage();
    }

    public UserMainPage clickOnUserMainPage() {
        return null;
    }
}
