package pages.music;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.actions;

public class MusicList extends MusicMainPage {
    private static final String MUSIC_LIST = "//wm-tracks-list//wm-track";
    private List<SelenideElement> list = new ArrayList<>();

    public MusicList() {
        list.addAll($$x(MUSIC_LIST));
    }

    public MusicTrack getTrack(int index) {
        return new MusicTrack(list.get(index));
    }

    public void deleteAllTracks() {
        for (SelenideElement track : list) {
            new MusicTrack(track).removeTrackFromFavorite();
        }
    }

    public boolean findAddedElement(String trackData) {
        for (SelenideElement webElement : list) {
            //Чтобы текста песен совпадали нужно чтоли и там и там был hover на них, либо его не было нигде
            //Я решил сделать, чтобы он был и там и там
            actions().moveToElement(webElement).build().perform();
            if (trackData.equals(webElement.getText()))
                return true;
        }
        return false;
    }
}
