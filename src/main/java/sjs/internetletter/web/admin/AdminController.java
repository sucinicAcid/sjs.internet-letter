package sjs.internetletter.web.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sjs.internetletter.domain.letter.Letter;
import sjs.internetletter.domain.letter.LetterService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final LetterService letterService;

    @GetMapping("/letters")
    public String letters(Model model) {
        List<Letter> letters = letterService.findLetters();
        model.addAttribute("letters", letters);
        return "/admin/letters";
    }

    @GetMapping("/letters/{letterId}")
    public String letter(@PathVariable Long letterId, Model model) {
        Letter findLetter = letterService.findOne(letterId);
        model.addAttribute("letter", findLetter);
        return "/admin/letter";
    }

}
