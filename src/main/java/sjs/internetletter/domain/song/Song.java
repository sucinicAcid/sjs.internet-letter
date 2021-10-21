package sjs.internetletter.domain.song;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {

    @Id @GeneratedValue
    @Column(name = "SONG_ID")
    private Long id;

    private String title;
    private String groupName;

    @CreationTimestamp
    private Date addDate;

    public static Song createSong(String title, String groupName) {
        Song song = new Song();
        song.setTitle(title);
        song.setGroupName(groupName);
        return song;
    }
}
