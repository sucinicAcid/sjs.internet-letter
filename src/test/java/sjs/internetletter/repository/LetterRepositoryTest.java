package sjs.internetletter.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sjs.internetletter.domain.letter.Letter;
import sjs.internetletter.domain.letter.LetterRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class LetterRepositoryTest {

    @Autowired
    private LetterRepository letterRepository;

    @Test
    void 편지추가() {
        //given
        Letter letter = new Letter();
        letter.setTitle("test title1");
        letter.setContent("test content1");

        //when
        Long savedId = letterRepository.save(letter);
        Letter findLetter = letterRepository.find(savedId);

        //then
        assertThat(findLetter.getContent()).isEqualTo(letter.getContent());
    }

    @Test
    void 편지_모두조회() {
        //given
        Letter letter1 = new Letter();
        letter1.setName("test name1");
        letter1.setTitle("test title1");
        letter1.setContent("test content1");
        letterRepository.save(letter1);

        Letter letter2 = new Letter();
        letter2.setName("test name2");
        letter2.setTitle("test title2");
        letter2.setContent("test content2");
        letterRepository.save(letter2);

        //when
        List<Letter> findLetters = letterRepository.findAll();

        //then
        assertThat(findLetters.size()).isEqualTo(2);
    }
}