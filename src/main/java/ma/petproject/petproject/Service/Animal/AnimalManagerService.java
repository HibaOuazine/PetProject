package ma.petproject.petproject.Service.Animal;


import ma.petproject.petproject.DAO.entities.Animal;
import ma.petproject.petproject.DAO.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class AnimalManagerService implements AnimalManager {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Boolean removeAnimal(Animal animal) {
        try {
            animalRepository.delete(animal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @Override
    public Boolean removeAnimalByID(Integer id) {
        try {
            animalRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Animal getAnimalById(Integer id) {
        return animalRepository.findById(id).get();
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        if (animalRepository.existsById(animal.getId())) {
            return animalRepository.save(animal);
        } else {
            return null;
        }
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
}
