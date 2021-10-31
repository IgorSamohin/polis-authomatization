package pages.music;

import pages.music.tracks.BaseMusicTrack;

public class HistoryMusicList<T extends BaseMusicTrack> extends MusicList<T> {
    private static final String MUSIC_LIST = "//wm-track[@track='{}']";

    public HistoryMusicList(Class<? extends T> impl) throws NoSuchMethodException {
        super(impl);
    }

    @Override
    protected String getMusicListLocator() {
        return MUSIC_LIST;
    }
}
