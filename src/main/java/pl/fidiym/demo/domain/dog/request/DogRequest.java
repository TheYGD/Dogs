package pl.fidiym.demo.domain.dog.request;

import lombok.Getter;

@Getter
public class DogRequest {
    private String name;
    private String breed;
    private String birthDateString;

    public DogRequest(String name, String breed, String birthDateString, String ownerUsername) {
        this.name = name;
        this.breed = breed;
        this.birthDateString = birthDateString;
    }
}
