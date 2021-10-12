package pages.music;

import static com.codeborne.selenide.Selenide.actions;

public class MyMusicPage extends MusicMainPage {

    public MusicList getMusicList() {
        return new MusicList();
    }

    public boolean isCurrentTrack(String trackData) {
        MusicList list = new MusicList();
        for (int i = 0; i < list.size(); i++) {
            //Чтобы текста песен совпадали нужно чтобы и там и там был hover на них, либо его не было нигде
            //Я решил сделать, чтобы он был и там и там
            actions().moveToElement(list.getWebElement(i)).build().perform();
            if (trackData.equals(list.getTrack(i).getText()))
                return true;
        }
        return false;
    }
}
