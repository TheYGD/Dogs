package pl.fidiym.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.fidiym.demo.domain.dog.Dog;
import pl.fidiym.demo.domain.dog.request.DogCardBasic;
import pl.fidiym.demo.support.DogMapper;

import java.util.*;

@Repository
public class DogRepository {

    private final HashMap<Integer, Dog> dogs;
    @Autowired
    private DogMapper dogMapper;

    public DogRepository() {
        this.dogs = new HashMap<>();
    }

    public Optional<Dog> findById(long id) {
        if (!dogs.containsKey((int)id)) {
            return Optional.empty();
        }

        return Optional.of(dogs.get((int) id));
    }

    public List<Dog> findAll() {
        return new LinkedList<Dog>(dogs.values());
    }

    public Dog create(Dog dog) {
        dogs.put(dogs.size(), dog);
        return dog;
    }

    public void deleteById(long id) {
        dogs.remove((int) id);
    }

    public List<DogCardBasic> findAllDogsCardBasics() {
        return dogs.values().stream()
                .map(e -> dogMapper.toDogCardBasic(e))
                .toList();
    }
}
