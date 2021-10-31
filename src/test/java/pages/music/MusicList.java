package pages.music;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.sleep;
import com.codeborne.selenide.SelenideElement;
import pages.music.tracks.BaseMusicTrack;
import pages.music.tracks.TrackData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

/**
 * Proxy for list
 */
public class MusicList<T extends BaseMusicTrack> extends MusicMainPage {
    private static final String MUSIC_LIST = "//wm-tracks-list//wm-track";
    private final Constructor<? extends T> constructor;

    public MusicList(Class<? extends T> impl) throws NoSuchMethodException {
        this.constructor = impl.getDeclaredConstructor(SelenideElement.class);
    }

    private List<T> getList() {
        ElementsCollection selenideElements = $$x(getMusicListLocator());

        ArrayList<T> list = new ArrayList<>(selenideElements.size());
        for (SelenideElement element : selenideElements) {
            T track = null;
            try {
                track = constructor.newInstance(element);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            list.add(track);
        }

        return list;
    }

    protected String getMusicListLocator() {
        return MUSIC_LIST;
    }

    public BaseMusicTrack getTrack(int index) {
        return getList().get(index);
    }

    public int size() {
        return getList().size();
    }

    public boolean findBy(TrackData trackData) {
        sleep(100);//todo у брать это безобразие (список не успевает подгружаться)
        for (BaseMusicTrack track : getList()) {
            TrackData trackData1 = track.getTrackData();
            if (trackData.equals(trackData1)) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return getList().isEmpty();
    }
}
