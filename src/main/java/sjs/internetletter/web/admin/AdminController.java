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

    @GetMapping("/letters/{letterId}/delete")
    public String delete(@PathVariable Long letterId) {
        Letter findLetter = letterService.findOne(letterId);
        // admin이 임의로 letterId를 설정할 경우, repository에 해당 letterId가 없을 수 있음
        if (findLetter != null) {
            letterService.removeOne(letterId);
        }
        return "redirect:/admin/letters";
    }
}
