package pl.fidiym.demo.domain.dog.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class DogCardDetails {
    private long id;
    private String name;
    private String breed;
    private LocalDate birthDate;
    private String ownerUsername;
}
