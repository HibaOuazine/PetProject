package ma.petproject.petproject.DAO.repositories;


import ma.petproject.petproject.DAO.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {
}
