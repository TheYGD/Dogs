package pl.fidiym.demo.support.exceptions;

public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException(long id) {
        super(String.format("Dog with id %d not found!", id));
    }
}
