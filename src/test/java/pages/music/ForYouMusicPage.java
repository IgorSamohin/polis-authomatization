package pages.music;

import pages.music.tracks.MusicTrack;

import java.lang.reflect.InvocationTargetException;

public class ForYouMusicPage extends MusicMainPage {
    public MusicList<MusicTrack> getMusicList() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return new MusicList<>(MusicTrack.class);
    }
}
