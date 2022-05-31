package pl.fidiym.demo.support;

import org.springframework.stereotype.Component;
import pl.fidiym.demo.domain.dog.Dog;
import pl.fidiym.demo.domain.dog.DogCardBasic;
import pl.fidiym.demo.domain.dog.request.DogRequest;

import java.time.LocalDate;

@Component
public class DogMapper {

    public Dog toDog(DogRequest dogRequest, String username) {
        Dog dog = new Dog(
                dogRequest.getName(),
                dogRequest.getBreed(),
                dogRequest.getBirthDateString() != null ? LocalDate.parse(dogRequest.getBirthDateString()) : null,
                username);

        return dog;
    }

    public DogCardBasic toDogCardBasic(Dog dog) {
        return new DogCardBasic(
                dog.getId(),
                dog.getName(),
                dog.getImageSource());
    }
}
