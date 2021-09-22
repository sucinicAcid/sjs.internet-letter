package sjs.internetletter.web.letter.form;

import javax.validation.constraints.NotBlank;

public class LetterForm {

    @NotBlank
    private String name;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
