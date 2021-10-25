package pages.music.tracks;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import com.codeborne.selenide.SelenideElement;


//todo сделать использование констант не через прямой вызов, а через метод, чтобы можно было перегружать только эти
// методы, а не все методы, которые используют другие константы
public class BaseMusicTrack {
    private static final String TRACK_COVER_LOCATOR = ".//*[@data-l='t,track']";
    private static final String TRACK_NAME_LOCATOR = ".//*[@data-l='t,title']";
    private static final String TRACK_ARTIST_LOCATOR = ".//*[@data-l='t,artist']";
    private static final String TRACK_ALBUM_LOCATOR = ".//*[@data-l='t,album']";
    private static final String TRACK_DURATION_LOCATOR = ".//*[@class='duration']";

    private static final String TRACK_HIDDEN_MENU_LOCATOR = ".//*[@data-l='t,track-actions']";
    private static final String TRACK_HIDDEN_MENU_POST_STATUS_LOCATOR = ".//*[@data-l='t,post-status']";
    protected SelenideElement track;

    public BaseMusicTrack(SelenideElement track) {
        this.track = track;
    }

    protected String getTrackCoverLocator() {
        return TRACK_COVER_LOCATOR;
    }

    protected String getTrackNameLocator() {
        return TRACK_NAME_LOCATOR;
    }

    protected String getTrackArtistLocator() {
        return TRACK_ARTIST_LOCATOR;
    }

    protected String getTrackAlbumLocator() {
        return TRACK_ALBUM_LOCATOR;
    }

    protected String getTrackDurationLocator() {
        return TRACK_DURATION_LOCATOR;
    }

    protected String getTrackHiddenMenuLocator() {
        return TRACK_HIDDEN_MENU_LOCATOR;
    }

    protected String getTrackHiddenMenuPostStatusLocator() {
        return TRACK_HIDDEN_MENU_POST_STATUS_LOCATOR;
    }

    public TrackData getTrackData() {
        return new TrackData(getTitle(), getArtist(), getAlbum(), getDuration());
    }

    public void hover() {
        actions().moveToElement(track).build().perform();
    }

    public BaseMusicTrack clickOnCover() {
        track.$x(getTrackCoverLocator()).click();
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
        return track.$x(getTrackNameLocator()).getText();
    }

    public String getArtist() {
        ElementsCollection selenideElements = track.$$x(getTrackArtistLocator());
        StringBuilder result = new StringBuilder();
        for (SelenideElement selenideElement : selenideElements) {
            result.append(selenideElement.getText());
        }
        return result.toString();
    }

    public String getAlbum() {
        return track.$x(getTrackAlbumLocator()).getText();
    }

    public String getDuration() {
        return track.$x(getTrackDurationLocator()).getText();
    }

    public BaseMusicTrack addToStatus() {
        track.hover().$x(getTrackHiddenMenuLocator()).click();
        $x(getTrackHiddenMenuPostStatusLocator()).click();
        return this;
    }
}
