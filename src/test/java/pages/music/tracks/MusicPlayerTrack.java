package pages.music.tracks;

import com.codeborne.selenide.SelenideElement;

import java.util.Date;

public class MusicPlayerTrack extends BaseMusicTrack {
    private static final String TRACK_DURATION_LOCATOR = ".//wm-player-duration";

    private static final String TRACK_COVER_LOCATOR = ".//*[@class='cover']";
    private static final String TRACK_NAME_LOCATOR = ".//*[@data-l='t,name']";
    private static final String TRACK_ARTIST_LOCATOR = ".//*[@class='artist']";

    public MusicPlayerTrack(SelenideElement track) {
        super(track);
    }

    @Override
    public String getDuration() {
        String duration = track.$x(getTrackDurationLocator()).getAttribute("duration");
        assert duration != null;

        int i = (int) Double.parseDouble(duration);
        Date time = new Date(i * 1000L);
        return String.format("%tM:%tS", time, time);
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
