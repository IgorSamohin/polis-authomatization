package pages.music.tracks;

import com.codeborne.selenide.SelenideElement;

public class TrackFromUserStatus extends BaseMusicTrack {
    private static final String TRACK_DURATION_LOCATOR = ".//*[@itemprop='duration']";

    public TrackFromUserStatus(SelenideElement track) {
        super(track);
    }

    @Override
    public BaseMusicTrack addToStatus() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getTrackDurationLocator() {
        return TRACK_DURATION_LOCATOR;
    }
}
