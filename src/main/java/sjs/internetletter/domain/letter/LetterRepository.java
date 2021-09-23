package sjs.internetletter.domain.letter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LetterRepository {

    private final EntityManager em;

    public Long save(Letter letter) {
        em.persist(letter);
        return letter.getId();
    }

    public Letter find(Long id) {
        return em.find(Letter.class, id);
    }

    public List<Letter> findAll() {
        return em.createQuery("select l from Letter l", Letter.class)
                .getResultList();
    }

    public void remove(Long id) {
        Letter findLetter = em.find(Letter.class, id);
        em.remove(findLetter);
    }
}
