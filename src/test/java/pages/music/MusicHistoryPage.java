package pages.music;

import pages.music.tracks.MusicTrack;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.$x;

public class MusicHistoryPage extends MusicMainPage {
    private final static String CLEAR_HISTORY = "//*[@class='clear' and @icon='clear2']";
    private final static String CONFIRM_DELETE = "//*[@data-l='t,submit' and @role='primary']";

    public HistoryMusicList<MusicTrack> getHistoryMusicList()
            throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return new HistoryMusicList<>(MusicTrack.class);
    }

    public void clearHistory() {
        $x(CLEAR_HISTORY).click();
        $x(CONFIRM_DELETE).click();
    }
}
