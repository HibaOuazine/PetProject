package ma.petproject.petproject.DAO.repositories;


import ma.petproject.petproject.DAO.entities.Care;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareRepository extends JpaRepository<Care,Integer> {
}
