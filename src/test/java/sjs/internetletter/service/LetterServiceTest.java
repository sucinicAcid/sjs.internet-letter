package sjs.internetletter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sjs.internetletter.domain.letter.Letter;
import sjs.internetletter.domain.letter.LetterService;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class LetterServiceTest {

    @Autowired
    LetterService letterService;

    @Test
    void 편지추가() {
        //given
        Letter letter = Letter.createLetter("test name",
                "test title",
                "test content");

        //when
        Long savedId = letterService.join(letter);

        //then
        assertThat(letter.getId()).isEqualTo(savedId);
    }

    @Test
    void 편지_모두조회() {
        //given
        Letter letter1 = Letter.createLetter("test name1",
                "test title1",
                "test content1");
        letterService.join(letter1);

        Letter letter2 = Letter.createLetter("test name2",
                "test title2",
                "test content2");
        letterService.join(letter2);

        //when
        List<Letter> findLetters = letterService.findLetters();

        //then
        assertThat(findLetters.size()).isEqualTo(2);
    }
}