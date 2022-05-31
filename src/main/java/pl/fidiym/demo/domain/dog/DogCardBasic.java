package pl.fidiym.demo.domain.dog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DogCardBasic {
    private long id;
    private String name;
    private String imageSource;
}
