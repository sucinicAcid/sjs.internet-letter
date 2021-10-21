package sjs.internetletter.domain.song;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sjs.internetletter.domain.letter.Letter;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SongRepository {

    private final EntityManager em;

    public Long save(Song song) {
        em.persist(song);
        return song.getId();
    }

    public Song find(Long id) {
        return em.find(Song.class, id);
    }

    public List<Song> findAll() {
        return em.createQuery("select s from Song s", Song.class)
                .getResultList();
    }

    public void remove(Long id) {
        Song findSong = em.find(Song.class, id);
        em.remove(findSong);
    }
}