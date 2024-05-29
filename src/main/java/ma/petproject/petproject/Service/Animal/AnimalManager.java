package ma.petproject.petproject.Service.Animal;



import ma.petproject.petproject.DAO.entities.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimalManager {
    Animal addAnimal(Animal animal);

    Boolean removeAnimal(Animal animal);

    Boolean removeAnimalByID(Integer id);

    Animal getAnimalById(Integer id);

    Animal updateAnimal(Animal animal);

    List<Animal> getAllAnimals();
}
