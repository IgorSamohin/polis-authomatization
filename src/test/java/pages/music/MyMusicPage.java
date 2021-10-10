package pages.music;

import static com.codeborne.selenide.Selenide.actions;

public class MyMusicPage extends MusicMainPage {

    public MusicList getMusicList() {
        return new MusicList();
    }

    public boolean isCurrentTrack(String trackData) {
        MusicList list = new MusicList();
        for (int i = 0; i < list.size(); i++) {
            actions().moveToElement(list.getWebElement(i)).build().perform();
            if (trackData.equals(list.getTrack(i).getText()))
                return true;
        }
        return false;
    }
}
