package pages.music;

import pages.music.tracks.MusicTrack;

import static com.codeborne.selenide.Selenide.$x;

public class CollectionPage extends MusicMainPage {
    private final static String COLLECTION_SETTINGS = "//*[@name='content' ]//*[@data-l='t,more']";
    private final static String DELETE_COLLECTION = "//*[@data-l='t,remove']";
    private final static String CONFIRM_DELETE = "//*[@data-l='t,submit' and @role='primary']";

    public MusicList<MusicTrack> getCollectionMusicList() throws NoSuchMethodException {
        return new MusicList<>(MusicTrack.class);
    }

    public void deleteCollection() {
        $x(COLLECTION_SETTINGS).click();
        $x(DELETE_COLLECTION).click();
        $x(CONFIRM_DELETE).click();
    }
}
