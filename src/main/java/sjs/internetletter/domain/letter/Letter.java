package sjs.internetletter.domain.letter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Letter {

    @Id
    @GeneratedValue
    @Column(name = "LETTER_ID")
    private Long id;

    private String name;
    private String title;
    private String content;

    public static Letter createLetter(String name, String title, String content) {
        Letter letter = new Letter();
        letter.setName(name);
        letter.setTitle(title);
        letter.setContent(content);
        return letter;
    }
}
