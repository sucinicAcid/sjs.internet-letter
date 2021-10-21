package sjs.internetletter.domain.song;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;

    @Test
    void 노래추가() {
        //given
        Song song = Song.createSong("test title", "test groupName");

        //when
        Long savedId = songRepository.save(song);
        Song findSong = songRepository.find(savedId);

        //then
        assertThat(findSong.getTitle()).isEqualTo(song.getTitle());
        assertThat(findSong.getGroupName()).isEqualTo(song.getGroupName());
    }

    @Test
    void 노래_모두조회() {
        //given
        Song song1 = Song.createSong("test title1", "test groupName1");
        songRepository.save(song1);

        Song song2 = Song.createSong("test title2", "test groupName2");
        songRepository.save(song2);

        //when
        List<Song> findSongs = songRepository.findAll();

        //then
        assertThat(findSongs.size()).isEqualTo(2);
    }
}