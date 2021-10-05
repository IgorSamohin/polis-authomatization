package pages.base;

import pages.music.MusicMainPage;
import pages.ToolBar;
import pages.UserMainPage;

public class LoggedUserBasePage extends BasePage{
    private ToolBar toolBar;

    public UserMainPage clickOnUserMainPage() {
        return toolBar.clickOnUserMainPage();
    }

    public MusicMainPage clickOnMusicMainPage() {
        return toolBar.clickOnMusicMainPage();
    }
}
