package ma.petproject.petproject.DAO.repositories;


import ma.petproject.petproject.DAO.entities.Grooming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroomingRepository extends JpaRepository<Grooming,Integer> {
}
