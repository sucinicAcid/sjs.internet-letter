package sjs.internetletter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjs.internetletter.domain.Letter;
import sjs.internetletter.repository.LetterRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;

    @Transactional
    public Long join(Letter letter) {
        return letterRepository.save(letter);
    }

    public List<Letter> findLetters() {
        return letterRepository.findAll();
    }
}
