package tests;

import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.UserMainPage;
import pages.music.MusicMainPage;
import pages.music.tracks.MusicTrack;
import pages.music.tracks.TrackData;

class MusicTest extends TestBase {

    @Test
    public void addSongToMyMusic() throws Exception {
        MusicMainPage musicMainPage = (MusicMainPage) new UserMainPage()
                .clickOnMusicMainPage();

        MusicTrack track = (MusicTrack) musicMainPage
                .clickOnMusicForYou()
                .getMusicList()
                .getTrack(0);

        track.addTrackToFavorite();
        TrackData trackData = track.getTrackData();

        Assertions.assertTrue(musicMainPage
                .clickOnMyMusic()
                .getMusicList()
                .findBy(trackData)
        );
    }

    @AfterEach
    public void clean() throws Exception {
        open(OK_RU_URL);
        MusicMainPage musicMainPage = (MusicMainPage) new UserMainPage()
                .clickOnUserMainPage()
                .clickOnMusicMainPage();

        musicMainPage
                .clickOnMyMusic()
                .deleteAllTracks();
    }
}
