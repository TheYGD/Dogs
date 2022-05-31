package pl.fidiym.demo.domain.dog;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Dog {
    private long id;
    private String name;
    private String breed;
    private LocalDate birthDate;
    private Integer motherId;
    private Integer fatherId;
    private String ownerUsername;
    private String imageSource;

    private  static long IDS = 0;


    public Dog(String name, String breed, LocalDate birthDate, String ownerUsername) {
        this.id = IDS++;
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.ownerUsername = ownerUsername;

        imageSource = "//" + Math.floor(Math.random() * 360);
    }
}
