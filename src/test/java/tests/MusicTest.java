package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.music.MusicMainPage;
import pages.music.MusicTrack;

class MusicTest extends TestBase {

    @Test
    public void addSongToMyMusic() {
        MusicMainPage musicMainPage = (MusicMainPage) this.userMainPage
                .clickOnMusicMainPage();

        MusicTrack track = musicMainPage
                .clickOnMusicForYou()
                .getMusicList()
                .getTrack(0);

        track.addTrackToFavorite();
        String trackData = track.getText();

        Assertions.assertTrue(musicMainPage
                .clickOnMyMusic()
                .getMusicList()
                .findAddedElement(trackData)
        );
    }

    @AfterEach
    public void clean() {
        MusicMainPage musicMainPage = (MusicMainPage) this.userMainPage
                .clickOnUserMainPage()
                .clickOnMusicMainPage();

        musicMainPage
                .clickOnMyMusic()
                .getMusicList()
                .deleteAllTracks();
    }
}
