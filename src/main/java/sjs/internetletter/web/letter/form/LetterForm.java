package sjs.internetletter.web.letter.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class LetterForm {

    @NotBlank
    private String name;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
