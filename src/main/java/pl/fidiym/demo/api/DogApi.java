package pl.fidiym.demo.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fidiym.demo.domain.dog.Dog;
import pl.fidiym.demo.domain.dog.DogCardBasic;
import pl.fidiym.demo.domain.dog.request.DogRequest;
import pl.fidiym.demo.service.DogService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dogs")
@AllArgsConstructor
public class DogApi {

    private DogService dogService;

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable long id) {
        Dog dog = dogService.getDog(id);
        return ResponseEntity.status(HttpStatus.OK).body(dog);
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.getAllDogs();
        return ResponseEntity.status(HttpStatus.OK).body(dogs);
    }

    @GetMapping("/names")
    public ResponseEntity<List<DogCardBasic>> getAllDogsCardBasics() {
        List<DogCardBasic> dogsNames = dogService.getAllDogsCardBasics();
        return ResponseEntity.status(HttpStatus.OK).body(dogsNames);
    }

    @PostMapping
    public ResponseEntity<Dog> addDog(@RequestBody DogRequest dogRequest) {
        Dog dog = dogService.addDog(dogRequest, "username");
        return ResponseEntity.status(HttpStatus.CREATED).body(dog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(@RequestBody DogRequest dogRequest,@PathVariable long id) {
        Dog dog = dogService.updateDog(dogRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(dog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateDog(@PathVariable long id) {
        dogService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
