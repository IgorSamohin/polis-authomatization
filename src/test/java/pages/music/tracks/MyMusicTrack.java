package pages.music.tracks;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import com.codeborne.selenide.SelenideElement;

public class MyMusicTrack extends BaseMusicTrack {
    private static final String REMOVE_MUSIC_FROM_MY_MUSIC = "//*[@data-tsid='remove_track' and @icon='close']";

    public MyMusicTrack(SelenideElement track) {
        super(track);
    }

    public void removeTrackFromFavorite() {
        actions().moveToElement(track).build().perform();
        $x(REMOVE_MUSIC_FROM_MY_MUSIC).click();
    }
}
