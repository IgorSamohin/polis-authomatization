package pages.music;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.TrackData;

public class MusicList<T extends BaseMusicTrack> extends MusicMainPage {
    private static final String MUSIC_LIST = "//wm-tracks-list//wm-track";
    private final List<T> list = new ArrayList<>();

    public MusicList(Class<? extends T> impl) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<? extends T> constructor = impl.getDeclaredConstructor(SelenideElement.class);
        ElementsCollection selenideElements = $$x(MUSIC_LIST);

        for (SelenideElement element : selenideElements) {
            T track = constructor.newInstance(element);
            list.add(track);
        }
    }

    public BaseMusicTrack getTrack(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public boolean findBy(TrackData trackData) {
        for (BaseMusicTrack track : list) {
            //Чтобы текста песен совпадали нужно чтоли и там и там был hover на них, либо его не было нигде
            //Я решил сделать, чтобы он был и там и там
            track.hover();
            if (trackData.equals(track.getTrackData())) {
                return true;
            }
        }

        return false;
    }
}
