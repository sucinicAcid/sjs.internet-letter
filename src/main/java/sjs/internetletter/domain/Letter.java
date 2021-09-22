package sjs.internetletter.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Letter {

    @Id
    @GeneratedValue
    @Column(name = "LETTER_ID")
    private Long id;

    private String name;
    private String title;
    private String content;
}
