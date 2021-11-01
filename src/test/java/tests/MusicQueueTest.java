package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.music.MusicMainPage;
import pages.music.MusicQueuePage;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.TrackData;

import java.util.ArrayList;
import java.util.List;

public class MusicQueueTest extends MusicTestBase {

    public static final int QUEUE_LENGTH = 5;

    /**
     * Заходит в "Музыку" -> в раздел "Для вас";
     * <p>
     * Нажимает на первый трек, чтобы поставить весь раздел "Для вас" в очередь.
     * <p>
     * Заходит в очередь.
     * <p>
     * Собирает данных о треках в очереди.
     * <p>
     * Проверяет, что при переключении на следующий трек в плеере начинает проигрываться именно тот трек, который
     * идет следующим в очереди.
     */
    @Test
    public void queueTest() throws NoSuchMethodException {
        MusicMainPage forYouPage = new MusicMainPage()
                .clickOnMusicForYou();

        forYouPage
                .getMusicList()
                .getTrack(0)
                .play()
                .pause();

        List<? extends BaseMusicTrack> musicList = forYouPage
                .goToQueuePage()
                .getMusicList()
                .getList();


        Assertions.assertNotEquals(0, musicList.size());
        int size = Math.min(musicList.size(), QUEUE_LENGTH);
        List<TrackData> tracksData = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            BaseMusicTrack track = musicList.get(i);
            tracksData.add(track.getTrackData());
        }

        MusicQueuePage musicQueuePage = new MusicQueuePage();
        for (TrackData trackData : tracksData) {
            TrackData currentTrackData = musicQueuePage.getCurrentTrackData();
            trackData = new TrackData(trackData.title, trackData.artist, "", trackData.duration);

            Assertions.assertEquals(trackData, currentTrackData);
            musicQueuePage.clickOnNextTrackButton();
        }
    }
}
