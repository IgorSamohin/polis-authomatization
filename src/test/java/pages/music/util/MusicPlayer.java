package pages.music.util;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;
import pages.music.MusicQueuePage;
import pages.music.MusicSearchPage;
import pages.music.tracks.MusicPlayerTrack;
import pages.music.tracks.TrackData;

public class MusicPlayer extends BasePage {

    public final static String LAYER_LOCATOR = "//music-layer//header";

    public final static String FORWARD_BUTTON_LOCATOR = "//*[@data-tsid='forward_button']";
    public final static String PLAY_BUTTON_LOCATOR = "//*[@data-tsid='play_button']";
    public final static String PAUSE_BUTTON_LOCATOR = "//*[@data-tsid='pause_button']";
    public final static String BACKWARD_BUTTON_LOCATOR = "//*[@data-tsid='backward_button']";

    public final static String GO_TO_QUEUE_BUTTON_LOCATOR = "//*[@data-tsid='current_playlist']";
    public final static String SEARCH_FIELD_LOCATOR = "//*[@data-tsid='inner_input']";

    public final static String CURRENT_TRACK_LOCATOR = "//*[@data-tsid='playing_track']//wm-card-details";

    public MusicSearchPage search(String trackName) {
        $x(SEARCH_FIELD_LOCATOR).setValue(trackName).pressEnter();
        return new MusicSearchPage();
    }

    public void clickOnPrevTrackButton() {
        $x(BACKWARD_BUTTON_LOCATOR).click();
    }

    public void clickOnNextTrackButton() {
        $x(FORWARD_BUTTON_LOCATOR).click();
    }

    public void clickOnPlayPauseButton() {
        SelenideElement playButton = $x(PLAY_BUTTON_LOCATOR);
        if (playButton.exists()) {
            playButton.click();
        } else {
            $x(PAUSE_BUTTON_LOCATOR).click();
        }
    }

    public MusicQueuePage goToQueuePage() {
        $x(GO_TO_QUEUE_BUTTON_LOCATOR).click();
        return new MusicQueuePage();
    }

    public TrackData getCurrentTrackData() {
        return new MusicPlayerTrack($x(LAYER_LOCATOR)).getTrackData();
    }

    public double getCurrentTrackProgress() {
        throw new UnsupportedOperationException();
    }
}
