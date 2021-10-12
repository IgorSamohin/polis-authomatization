package pages.music;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.actions;

public class MusicTrack {
    private static final String ADD_MUSIC_TO_MY_MUSIC = "//*[@name='controls']//*[@data-l='t,add']";
    private static final String REMOVE_MUSIC_FROM_MY_MUSIC = "//*[@name='controls']//*[@data-tsid='remove_track']";

    private SelenideElement track;

    public MusicTrack(SelenideElement track) {
        this.track = track;
    }

    public void addTrackToFavorite() {
        actions().moveToElement(track).build().perform();
        $x(ADD_MUSIC_TO_MY_MUSIC).click();
    }

    public void removeTrackFromFavorite() {
        actions().moveToElement(track).build().perform();
        $x(REMOVE_MUSIC_FROM_MY_MUSIC).click();
    }

    public String getText() {
        return track.getText();
    }
}
