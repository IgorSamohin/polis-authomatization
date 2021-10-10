package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.music.MusicMainPage;
import pages.music.MusicTrack;

class MusicTest extends TestBase {

    @Test
    public void addSongToMyMusic() {
        // Тут почему-то музыка открывается-закрывается-открывается. Не могу понять почему так
        MusicMainPage musicMainPage = (MusicMainPage) this.userMainPage
                .clickOnMusicMainPage();

        MusicTrack track = musicMainPage.
                clickOnMusicForYou()
                .getMusicList()
                .getTrack(0);

        track.addTrackToFavorite();
        String trackData = track.getText();

        Assertions.assertTrue(musicMainPage
                .clickOnMyMusic()
                .isCurrentTrack(trackData)
        );
    }

    @AfterEach
    public void clean() {
        // Почему-то происходит двойное нажатие на музыку (как в самом тесте, но тут музыка не открывается вообще).
        // Пришлось сделать вот так, чтобы музыка точно открылась
        MusicMainPage musicMainPage = (MusicMainPage) this.userMainPage
                .clickOnMusicMainPage()
                .clickOnUserMainPage()
                .clickOnMusicMainPage();

        musicMainPage
                .clickOnMyMusic()
                .getMusicList()
                .deleteAllTracks();
    }
}
