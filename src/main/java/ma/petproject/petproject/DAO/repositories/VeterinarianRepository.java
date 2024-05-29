package ma.petproject.petproject.DAO.repositories;


import ma.petproject.petproject.DAO.entities.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<Veterinarian,Integer> {
}
