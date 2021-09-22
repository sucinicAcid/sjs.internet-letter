package sjs.internetletter.web.letter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sjs.internetletter.domain.letter.LetterService;
import sjs.internetletter.web.letter.form.LetterForm;

@Controller
@RequiredArgsConstructor
@RequestMapping("/letters")
public class LetterController {

    private final LetterService letterService;

    @GetMapping
    public String addForm(@ModelAttribute("form") LetterForm form) {
        return "letters/addForm";
    }
}
