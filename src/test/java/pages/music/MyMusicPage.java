package pages.music;

import pages.music.tracks.MyMusicTrack;

import java.lang.reflect.InvocationTargetException;

public class MyMusicPage extends MusicMainPage {

    public MusicList<MyMusicTrack> getMusicList()
            throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return new MusicList<>(MyMusicTrack.class);
    }

    public void deleteAllTracks()
            throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        MusicList<MyMusicTrack> musicList = getMusicList();
        for (int i = 0; i < musicList.size(); i++) {
            MyMusicTrack track = (MyMusicTrack) musicList.getTrack(i);
            track.removeTrackFromFavorite();
        }
    }
}
