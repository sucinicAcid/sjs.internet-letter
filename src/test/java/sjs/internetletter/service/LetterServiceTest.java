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
        Letter letter = new Letter();
        letter.setName("name");
        letter.setTitle("title");
        letter.setContent("content");

        //when
        Long savedId = letterService.join(letter);

        //then
        assertThat(letter.getId()).isEqualTo(savedId);
    }

    @Test
    void 편지_모두조회() {
        //given
        Letter letter1 = new Letter();
        letter1.setName("test name1");
        letter1.setTitle("test title1");
        letter1.setContent("test content1");
        letterService.join(letter1);

        Letter letter2 = new Letter();
        letter2.setName("test name2");
        letter2.setTitle("test title2");
        letter2.setContent("test content2");
        letterService.join(letter2);

        //when
        List<Letter> findLetters = letterService.findLetters();

        //then
        assertThat(findLetters.size()).isEqualTo(2);
    }
}