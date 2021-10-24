package pages.music.tracks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Date;

public class MusicPlayerTrack extends BaseMusicTrack {
    //    private final static String CURRENT_TRACK_LOCATOR = "//*[@data-tsid='playing_track']//wm-card-details";
    private static final String TRACK_DURATION_LOCATOR = ".//wm-player-duration";

    private static final String TRACK_COVER_LOCATOR = ".//*[@class='cover']";
    private static final String TRACK_NAME_LOCATOR = ".//*[@data-l='t,name']";
    private static final String TRACK_ARTIST_LOCATOR = ".//*[@data-l='t,artists']";

    public MusicPlayerTrack(SelenideElement track) {
        super(track);
    }

    @Override
    public String getDuration() {
        String duration = track.$x(TRACK_DURATION_LOCATOR).getAttribute("duration");
        assert duration != null;

        int i = (int) Double.parseDouble(duration);
        Date time = new Date(i * 1000L);
        return String.format("%tM:%tS", time, time);
    }

    @Override
    public BaseMusicTrack clickOnCover() {
        track.$x(TRACK_COVER_LOCATOR).click();
        return this;
    }

    @Override
    public String getTitle() {
        return track.$x(TRACK_NAME_LOCATOR).getText();
    }

    @Override
    public String getArtist() {
        ElementsCollection selenideElements = track.$$x(TRACK_ARTIST_LOCATOR);
        StringBuilder result = new StringBuilder();
        for (SelenideElement selenideElement : selenideElements) {
            result.append(selenideElement.getText());
        }
        return result.toString();
    }

    @Override
    public String getAlbum() {
        return "";
    }
}
