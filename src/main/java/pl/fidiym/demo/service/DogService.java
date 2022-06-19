package pl.fidiym.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fidiym.demo.domain.dog.Dog;
import pl.fidiym.demo.domain.dog.request.DogCardBasic;
import pl.fidiym.demo.domain.dog.request.DogRequest;
import pl.fidiym.demo.domain.dog.response.DogCardDetails;
import pl.fidiym.demo.repository.DogRepository;
import pl.fidiym.demo.support.DogMapper;
import pl.fidiym.demo.support.DogExceptionSupplier;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class DogService {

    private DogRepository dogRepository;
    private DogExceptionSupplier exceptionSupplier;
    private DogMapper dogMapper;

    public Dog getDog(long id) {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(exceptionSupplier.dogNotFoundException(id));

        return dog;
    }

    public List<Dog> getAllDogs() {
        List<Dog> dogs = dogRepository.findAll();
        return dogs;
    }

    public Dog addDog(DogRequest dogRequest, String username) {
        Dog dog = dogMapper.toDog(dogRequest, username);

        return dogRepository.create(dog);
    }

    @Transactional
    public Dog updateDog(DogRequest dogRequest, long id) {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(exceptionSupplier.dogNotFoundException(id));

        if (dogRequest.getName() != null) {
            dog.setName(dogRequest.getName());
        }

        if (dogRequest.getBreed() != null) {
            dog.setBreed(dogRequest.getBreed());
        }

        if (dogRequest.getBirthDateString() != null) {
            dog.setBirthDate(LocalDate.parse(dogRequest.getBirthDateString()));
        }

        return dog;
    }

    public void deleteById(long id) {
        dogRepository.findById(id)
                .orElseThrow(exceptionSupplier.dogNotFoundException(id));

        dogRepository.deleteById(id);
    }

    public List<DogCardBasic> getAllDogsCardBasics() {
        return dogRepository.findAllDogsCardBasics();
    }

    public DogCardDetails getDogsCardDetails(long id) {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(exceptionSupplier.dogNotFoundException(id));

        return dogMapper.toDogCardDetails(dog);
    }
}
