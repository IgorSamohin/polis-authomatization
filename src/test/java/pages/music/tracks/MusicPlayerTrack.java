package pages.music.tracks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Date;

public class MusicPlayerTrack extends BaseMusicTrack {
    private static final String TRACK_DURATION_LOCATOR = ".//wm-player-duration";

    private static final String TRACK_COVER_LOCATOR = ".//*[@class='cover']";
    private static final String TRACK_NAME_LOCATOR = ".//*[@data-l='t,name']";
    private static final String TRACK_ARTIST_LOCATOR = ".//*[@class='artist']";
    private static final String THUMB_LOCATOR = ".//wm-player-duration//*[@class='thumb']";
    public static final int TIME_LENGTH = 5;

    public MusicPlayerTrack(SelenideElement track) {
        super(track);
    }

    @Override
    public String getDuration() {
        String duration = track.$x(THUMB_LOCATOR).should(Condition.exist).innerText();
        return duration.substring(duration.length() - TIME_LENGTH);
    }

    @Override
    protected String getTrackDurationLocator() {
        return TRACK_DURATION_LOCATOR;
    }

    @Override
    protected String getTrackCoverLocator() {
        return TRACK_COVER_LOCATOR;
    }

    @Override
    protected String getTrackNameLocator() {
        return TRACK_NAME_LOCATOR;
    }

    @Override
    protected String getTrackArtistLocator() {
        return TRACK_ARTIST_LOCATOR;
    }

    @Override
    public String getAlbum() {
        return "";
    }
}
