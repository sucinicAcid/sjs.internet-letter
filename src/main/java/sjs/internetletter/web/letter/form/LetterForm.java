package sjs.internetletter.web.letter.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class LetterForm {

    @NotBlank
    @Size(max = 10, message = "10글자 이하로 작성해주세요")
    private String name;

    @NotBlank
    @Size(max = 30, message = "30글자 이하로 작성해주세요")
    private String title;

    @NotBlank
    @Size(max = 300, message = "300글자 이하로 작성해주세요")
    private String content;
}
