package pages.music.tracks;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class TrackData {
    public final String title;
    public final String artist;
    public final String album;
    public final String duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrackData trackData = (TrackData) o;
        return Objects.equal(title, trackData.title)
                && Objects.equal(artist, trackData.artist)
                && Objects.equal(album, trackData.album)
                && Objects.equal(duration, trackData.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, artist, album, duration);
    }
}
