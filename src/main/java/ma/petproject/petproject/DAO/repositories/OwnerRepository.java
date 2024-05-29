package ma.petproject.petproject.DAO.repositories;



import ma.petproject.petproject.DAO.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
