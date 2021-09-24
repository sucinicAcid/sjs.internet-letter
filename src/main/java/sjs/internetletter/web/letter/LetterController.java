package sjs.internetletter.web.letter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sjs.internetletter.domain.letter.Letter;
import sjs.internetletter.domain.letter.LetterService;
import sjs.internetletter.web.letter.form.LetterForm;

@Controller
@RequiredArgsConstructor
@RequestMapping("/letters")
@Slf4j
public class LetterController {

    private final LetterService letterService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("form") LetterForm form) {
        return "letters/addForm";
    }

    @PostMapping("/add")
    public String addLetter(@Validated @ModelAttribute("form") LetterForm form,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "letters/addForm";
        }

        Letter letter = Letter.createLetter(form.getName(), form.getTitle(), form.getContent());
        letterService.join(letter);

        return "redirect:/letters/complete";
    }

    @GetMapping("/complete")
    public String complete() {
        log.info("/letters/complete");
        return "letters/complete";
    }
}
