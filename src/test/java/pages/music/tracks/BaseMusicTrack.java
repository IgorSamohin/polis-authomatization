package pages.music.tracks;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.actions;
import com.codeborne.selenide.SelenideElement;

import java.util.LinkedList;

public class BaseMusicTrack {
    protected static final String TRACK_COVER_LOCATOR = ".//slot[@data-l='t,track']";
    protected static final String TRACK_NAME_LOCATOR = ".//*[@data-l='t,title']";
    protected static final String TRACK_ARTIST_LOCATOR = ".//*[@data-l='t,artist']";
    protected static final String TRACK_ALBUM_LOCATOR = ".//*[@data-l='t,album']";
    protected static final String TRACK_DURATION_LOCATOR = ".//*[@class='duration']";
    protected SelenideElement track;

    public BaseMusicTrack(SelenideElement track) {
        this.track = track;
    }

    public TrackData getTrackData() {
        return new TrackData(getTitle(), getArtist(), getAlbum(), getDuration());
    }

    public void hover() {
        actions().moveToElement(track).build().perform();
    }

    public BaseMusicTrack clickOnCover() {
        track.$x(TRACK_COVER_LOCATOR).click();
        return this;
    }

    //Избыточность нужна для более удобного чтения тестов
    public BaseMusicTrack play() {
        return clickOnCover();
    }

    public BaseMusicTrack pause() {
        return clickOnCover();
    }

    public String getTitle() {
        return track.$x(TRACK_NAME_LOCATOR).getText();
    }

    public String getArtist() {
        ElementsCollection selenideElements = track.$$x(TRACK_ARTIST_LOCATOR);
        StringBuilder result = new StringBuilder();
        for (SelenideElement selenideElement : selenideElements) {
            result.append(selenideElement.getText());
        }
        return result.toString();
    }

    public String getAlbum() {
        return track.$x(TRACK_ALBUM_LOCATOR).getText();
    }

    public String getDuration() {
        return track.$x(TRACK_DURATION_LOCATOR).getText();
    }
}
