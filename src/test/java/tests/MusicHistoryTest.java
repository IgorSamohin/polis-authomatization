package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.UserMainPage;
import pages.music.ForYouMusicPage;
import pages.music.HistoryMusicList;
import pages.music.MusicList;
import pages.music.MusicMainPage;

import static com.codeborne.selenide.Selenide.open;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.MusicTrack;

public class MusicHistoryTest extends MusicTestBase {

    /**
     * Заходит в "Музыку" -> в раздел "Для вас"
     * <p></p>
     * Запускает первую песню
     * <p></p>
     * Она играет 30 секунд
     * <p></p>
     * Заходит в "Моя музыка" → "История"
     * <p></p>
     * Проверяет, что в истории отображается прослушанный трек
     */
    @Test
    public void historyTest() throws NoSuchMethodException {
        ForYouMusicPage forYouMusicPage = new MusicMainPage()
                .clickOnMusicForYou();

        MusicList<? extends BaseMusicTrack> musicList = forYouMusicPage
                .getMusicList();

        String trackName = musicList
                .getTrack(0)
                .play(31000)
                .pause()
                .getTitle();

        HistoryMusicList<MusicTrack> list = forYouMusicPage
                .clickOnMyMusic()
                .clickOnMusicHistoryPage()
                .getHistoryMusicList();

        String historyTrackName = list.getTrack(0)
                .getTitle();

        Assertions.assertEquals(trackName, historyTrackName);
    }

    @AfterEach
    public void clearHistory() {
        open(OK_RU_URL);

        MusicMainPage musicMainPage = (MusicMainPage) new UserMainPage()
                .clickOnUserMainPage()
                .clickOnMusicMainPage();

        musicMainPage
                .clickOnMyMusic()
                .clickOnMusicHistoryPage()
                .clearHistory();
    }
}
