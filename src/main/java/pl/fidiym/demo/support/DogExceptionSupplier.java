package pl.fidiym.demo.support;

import org.springframework.stereotype.Component;
import pl.fidiym.demo.support.exceptions.DogNotFoundException;

import java.util.function.Supplier;

@Component
public class DogExceptionSupplier {
    public Supplier<DogNotFoundException> dogNotFoundException(long id) {
        return () -> new DogNotFoundException(id);
    }
}
