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
        Letter letter = Letter.createLetter("test name",
                "test title",
                "test content");

        //when
        Long savedId = letterRepository.save(letter);
        Letter findLetter = letterRepository.find(savedId);

        //then
        assertThat(findLetter.getContent()).isEqualTo(letter.getContent());
    }

    @Test
    void 편지_모두조회() {
        //given
        Letter letter1 = Letter.createLetter("test name1",
                "test title1",
                "test content1");
        letterRepository.save(letter1);

        Letter letter2 = Letter.createLetter("test name2",
                "test title2",
                "test content2");
        letterRepository.save(letter2);

        //when
        List<Letter> findLetters = letterRepository.findAll();

        //then
        assertThat(findLetters.size()).isEqualTo(2);
    }
}