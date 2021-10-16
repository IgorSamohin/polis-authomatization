package pages.music;

import pages.base.LoggedUserBasePage;

import static com.codeborne.selenide.Selenide.$x;

public class MusicMainPage extends LoggedUserBasePage {
    private final static String GO_TO_MY_MUSIC = "//*[@data-l='t,library' and @data-tsid='library']";
    private final static String GO_TO_MUSIC_FOR_YOU = "//*[@data-l='t,showcase' and @data-tsid='showcase']";

    public MyMusicPage clickOnMyMusic() {
        $x(GO_TO_MY_MUSIC).click();
        return new MyMusicPage();
    }

    public ForYouMusicPage clickOnMusicForYou() {
        $x(GO_TO_MUSIC_FOR_YOU).click();
        return new ForYouMusicPage();
    }
}
