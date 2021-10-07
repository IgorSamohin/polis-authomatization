package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.music.MusicBasePage;

class MusicTest extends TestBase {
    @Test
    public void addSongToMyMusic() {
        MusicBasePage musicMainPage = (MusicBasePage) this.userMainPage
                .clickOnMusicMainPage();
//                .переход к "Для вас"
//
//        Track track = musicMainPage
//                .взятие списка песен
//                .взятие первой песни
//
//        track
//                .добавление песни в мою музыку


//        List<Track> tracks = musicMainPage
//                .переход в "Моя музыка"
//                .взятие списка песен

//        for (Track t: tracks) {
//             поиск в списке песни с такими же данными, которые сохранили
//        }
    }

    @AfterEach
    public void clean(){
        //перейти к моей музыке
        //удалить все треки оттуда
    }
}
