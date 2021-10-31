package tests;

import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.UserMainPage;
import pages.music.MusicMainPage;
import pages.music.tracks.MusicTrack;
import pages.music.tracks.TrackData;

class MusicTest extends MusicTestBase {

    @Test
    public void addSongToMyMusic() throws Exception {
        MusicMainPage musicMainPage = new MusicMainPage();

        MusicTrack track = (MusicTrack) musicMainPage
                .clickOnMusicForYou()
                .getMusicList()
                .getTrack(0);

        TrackData trackData = track.getTrackData();
        track.addTrackToFavorite();

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
