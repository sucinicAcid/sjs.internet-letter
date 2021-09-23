package sjs.internetletter.domain.letter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Letter findOne(Long letterId) {
        return letterRepository.find(letterId);
    }

    @Transactional
    public void removeOne(Long letterId) {
        letterRepository.remove(letterId);
    }
}
