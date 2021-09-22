package sjs.internetletter.web.letter.form;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LetterForm {

    @NotBlank
    private String name;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
