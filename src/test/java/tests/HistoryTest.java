package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.UserMainPage;
import pages.music.MusicMainPage;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.open;

public class HistoryTest extends TestBase {

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
    public void historyTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        MusicMainPage mainMusicPage = ((MusicMainPage) new UserMainPage()
                .clickOnMusicMainPage());

        String trackName = mainMusicPage.clickOnMusicForYou()
                .getMusicList()
                .getTrack(0)
                .play(30000)
                .pause()
                .getTitle();

        String historyTrackName = mainMusicPage.clickOnMyMusic()
                .clickOnMusicHistoryPage()
                .getHistoryMusicList()
                .getTrack(0)
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
