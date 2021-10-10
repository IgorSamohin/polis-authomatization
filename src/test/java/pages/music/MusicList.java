package pages.music;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class MusicList extends MusicMainPage {
    private static final By MUSIC_LIST = By.xpath("//wm-tracks-list//wm-track");
    private List<WebElement> list = new ArrayList<>();

    public MusicList() {
        list.addAll($$(MUSIC_LIST));
    }

    public WebElement getWebElement(int index) {
        return list.get(index);
    }

    public MusicTrack getTrack(int index) {
        return new MusicTrack(list.get(index));
    }

    public int size() {
        return list.size();
    }

    public void deleteAllTracks() {
        if (list.size() > 0) {
            for (WebElement track : list) {
                new MusicTrack(track).removeTrackFromFavorite();
            }
        }
    }
}
