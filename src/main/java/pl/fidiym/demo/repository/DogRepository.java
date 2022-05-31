package pl.fidiym.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.fidiym.demo.domain.dog.Dog;
import pl.fidiym.demo.domain.dog.DogCardBasic;
import pl.fidiym.demo.support.DogMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DogRepository {

    private final List<Dog> dogList;
    @Autowired
    private DogMapper dogMapper;

    public DogRepository() {
        this.dogList = new ArrayList<>();
    }

    public Optional<Dog> findById(long id) {
        if (id >= dogList.size() || id < 0) {
            return Optional.empty();
        }

        return Optional.of(dogList.get((int) id));
    }

    public List<Dog> findAll() {
        return List.copyOf(dogList);
    }

    public Dog create(Dog dog) {
        dogList.add(dog);
        return dog;
    }

    public void deleteById(long id) {
        dogList.remove((int) id);
    }

    public List<DogCardBasic> findAllDogsCardBasics() {
        return dogList.stream()
                .map(e -> dogMapper.toDogCardBasic(e))
                .toList();
    }
}
