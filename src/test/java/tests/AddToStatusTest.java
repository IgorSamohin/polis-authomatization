package tests;

import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import pages.UserMainPage;
import pages.music.MusicMainPage;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.TrackData;
import pages.music.tracks.TrackFromUserStatus;
import pages.profile.ProfileStatus;
import pages.profile.UserProfilePage;

import java.lang.reflect.InvocationTargetException;

public class AddToStatusTest extends TestBase {
    @Test
    public void addMusicToStatus()
            throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        BaseMusicTrack track = ((MusicMainPage) new UserMainPage()
                .clickOnMusicMainPage())
                .clickOnMusicForYou()
                .getMusicList()
                .getTrack(0);

        TrackData data = track.getTrackData();

        track.addToStatus();

        ProfileStatus status = new MusicMainPage()
                .clickOnUserMainPage()
                .clickOnUserProfilePage()
                .getStatus();

        TrackFromUserStatus statusTrack = status.getMediaContent();
        assertNotNull(statusTrack);
        TrackData trackData = statusTrack.getTrackData();
        assertEquals(data, trackData);
    }

    @AfterEach
    public void cleanStatus() {
        open(OK_RU_URL);

        //Удаление записи из ленты
        UserProfilePage userProfilePage = new UserMainPage()
                .clickOnUserProfilePage();

        userProfilePage
                .getStatusNoteInFeed()
                .delete();

        //Удаление статуса
        userProfilePage
                .getStatus()
                .deleteStatus();
    }
}
