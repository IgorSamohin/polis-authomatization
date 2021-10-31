package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.UserMainPage;
import pages.music.MusicMainPage;

import static com.codeborne.selenide.Selenide.open;

public class MusicCollectionTest extends MusicTestBase {
    /**
     * Заходит в "Музыку" → в раздел "Для вас"
     * <p>
     * Нажимает "добавить трек в сборник"
     * <p>
     * Нажимает создать сборник
     * <p>
     * Вводит название сборника и нажимает галочку
     * <p>
     * Заходит в раздел "Моя музыка" → "сборник"
     * <p>
     * Проверяет, что там находится добавленная песня
     */

    private final static String collectionName = "New collection";

    @Test
    public void collectionCreate() throws NoSuchMethodException {
        MusicMainPage mainMusicPage = new MusicMainPage();

        String trackName = mainMusicPage
                .clickOnMusicForYou()
                .getMusicList()
                .getTrack(0)
                .addTrackToNewCollection(collectionName)
                .getTitle();

        String collectionTrackName = mainMusicPage
                .clickOnCollectionPage(collectionName)
                .getCollectionMusicList()
                .getTrack(0)
                .getTitle();

        Assertions.assertEquals(trackName, collectionTrackName);
    }

    @AfterEach
    public void collectionDelete() {
        open(OK_RU_URL);

        MusicMainPage musicMainPage = (MusicMainPage) new UserMainPage()
                .clickOnUserMainPage()
                .clickOnMusicMainPage();

        musicMainPage
                .clickOnCollectionPage(collectionName)
                .deleteCollection();
    }
}
