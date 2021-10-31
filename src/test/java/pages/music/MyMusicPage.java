package pages.music;

import pages.music.tracks.MyMusicTrack;

public class MyMusicPage extends MusicMainPage {

    public MusicList<MyMusicTrack> getMusicList() throws NoSuchMethodException {
        return new MusicList<>(MyMusicTrack.class);
    }

    public void deleteAllTracks() throws NoSuchMethodException {
        MusicList<MyMusicTrack> musicList = getMusicList();
        for (int i = 0; i < musicList.size(); i++) {
            MyMusicTrack track = (MyMusicTrack) musicList.getTrack(i);
            track.removeTrackFromFavorite();
        }
    }
}
