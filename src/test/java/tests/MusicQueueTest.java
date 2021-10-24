package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.UserMainPage;
import pages.music.MusicList;
import pages.music.MusicMainPage;
import pages.music.MusicQueuePage;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.TrackData;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MusicQueueTest extends TestBase {

    @Test
    public void queueTest()
            throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MusicMainPage forYouPage = ((MusicMainPage) new UserMainPage()
                .clickOnMusicMainPage())
                .clickOnMusicForYou();

        forYouPage
                .getMusicList()
                .getTrack(0)
                .play()
                .pause();

        MusicList<? extends BaseMusicTrack> musicList = forYouPage
                .goToQueuePage()
                .getMusicList();

        Assertions.assertNotEquals(0, musicList.size());
        List<TrackData> tracksData = new ArrayList<>(musicList.size());
        for (int i = 0; i < musicList.size(); i++) {
            tracksData.add(musicList.getTrack(i).getTrackData());
        }

        MusicQueuePage musicQueuePage = new MusicQueuePage();
        for (TrackData trackData : tracksData) {
            TrackData currentTrackData = musicQueuePage.getCurrentTrackData();

            if (!trackData.equals(currentTrackData)) {
                System.out.println("");
            }
            Assertions.assertEquals(trackData, currentTrackData);
            musicQueuePage.clickOnNextTrackButton();
        }
    }

}
