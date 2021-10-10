package pages.base;

import pages.LoginPage;
import pages.ToolBar;
import pages.UserMainPage;
import pages.music.MusicMainPage;

public class LoggedUserBasePage extends BasePage {
    private final ToolBar toolBar = new ToolBar();

    public UserMainPage clickOnUserMainPage() {
        return toolBar.clickOnUserMainPage();
    }

    /**
     * @return MusicBasePage if currently open any other page or UserMainPage if current page is MusicBasePage
     */
    public LoggedUserBasePage clickOnMusicMainPage() {
        MusicMainPage musicMainPage = toolBar.clickOnMusicMainPage();

        if (this instanceof MusicMainPage) {
            return new UserMainPage();
        }

        return musicMainPage;
    }

    public LoginPage doLogout() {
        return toolBar.doLogout();
    }
}
