package pages.music;

import pages.base.LoggedUserBasePage;

import static com.codeborne.selenide.Selenide.$x;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.MusicTrack;
import pages.music.util.MusicPlayer;

import java.lang.reflect.InvocationTargetException;

public class MusicMainPage extends LoggedUserBasePage {
    private final MusicPlayer player = new MusicPlayer();
    private final static String GO_TO_MY_MUSIC = "//*[@data-l='t,library' and @data-tsid='library']";
    private final static String GO_TO_MUSIC_FOR_YOU = "//*[@data-l='t,showcase' and @data-tsid='showcase']";

    /**
     * Returns list of tracks on a page. MusicTrack is default element's type.
     * Override it if you need other type of elements in the list.
     */
    public MusicList<? extends BaseMusicTrack> getMusicList()
            throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return new MusicList<>(MusicTrack.class);
    }

    public MyMusicPage clickOnMyMusic() {
        $x(GO_TO_MY_MUSIC).click();
        return new MyMusicPage();
    }

    public ForYouMusicPage clickOnMusicForYou() {
        $x(GO_TO_MUSIC_FOR_YOU).click();
        return new ForYouMusicPage();
    }

    public MusicSearchPage search(String trackName) {
        return player.search(trackName);
    }

    public void clickOnPrevTrackButton() {
        player.clickOnPrevTrackButton();
    }

    public void clickOnNextTrackButton() {
        player.clickOnNextTrackButton();
    }

    public void clickOnPlayPauseButton() {
        player.clickOnPlayPauseButton();
    }

    public MusicQueuePage goToQueuePage() {
        return player.goToQueuePage();
    }

    public String getCurrentTrackData() {
        return player.getCurrentTrackData();
    }

    public double getCurrentTrackProgress() {
        return player.getCurrentTrackProgress();
    }
}
