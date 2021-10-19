package pages.music.tracks;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import com.codeborne.selenide.SelenideElement;

public class MusicTrack extends BaseMusicTrack {
    private static final String ADD_MUSIC_TO_MY_MUSIC = "//*[@data-l='t,add' and @data-tsid='track_add']";

    public MusicTrack(SelenideElement track) {
        super(track);
    }

    public void addTrackToFavorite() {
        actions().moveToElement(track).build().perform();
        $x(ADD_MUSIC_TO_MY_MUSIC).click();
    }
}
