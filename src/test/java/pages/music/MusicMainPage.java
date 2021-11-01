package pages.music;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.sleep;
import pages.base.LoggedUserBasePage;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.MusicTrack;
import pages.music.tracks.TrackData;
import pages.music.util.MusicPlayer;

import static com.codeborne.selenide.Selenide.$x;

public class MusicMainPage extends LoggedUserBasePage {
    private final static String GO_TO_MY_MUSIC = "//*[@data-l='t,library' and @data-tsid='library']";
    private final static String GO_TO_MUSIC_FOR_YOU = "//*[@data-l='t,showcase' and @data-tsid='showcase']";
    private final static String GO_TO_MUSIC_HISTORY = "//*[@data-l='t,history' and @data-tsid='history']";
    private final MusicPlayer player = new MusicPlayer();

    /**
     * Returns list of tracks on a page. MusicTrack is default element's type.
     * Override it if you need other type of elements in the list.
     */
    public MusicList<? extends BaseMusicTrack> getMusicList() throws NoSuchMethodException {
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

    public CollectionPage clickOnCollectionPage(String collectionName) {
        $x(GO_TO_MY_MUSIC).click();
        $x("//*[@data-l='t,playlist' and div='" + collectionName + "']").click();
        return new CollectionPage();
    }

    public MusicHistoryPage clickOnMusicHistoryPage() {
        $x(GO_TO_MY_MUSIC).click();
        $x(GO_TO_MY_MUSIC).click(); // Для раскрытия списка
        $x(GO_TO_MUSIC_HISTORY).shouldBe(Condition.visible).click();
        return new MusicHistoryPage();
    }

    public MusicSearchPage search(String trackName) {
        return player.search(trackName);
    }

    public void clickOnPrevTrackButton() {
        player.clickOnPrevTrackButton();
    }

    public MusicMainPage clickOnNextTrackButton() {
        player.clickOnNextTrackButton();
        return this;
    }

    public MusicMainPage clickOnPlayPauseButton() {
        player.clickOnPlayPauseButton();
        return this;
    }

    public MusicQueuePage goToQueuePage() {
        return player.goToQueuePage();
    }

    public TrackData getCurrentTrackData() {
        return player.getCurrentTrackData();
    }

    public double getCurrentTrackProgress() {
        return player.getCurrentTrackProgress();
    }
}
