package ma.petproject.petproject.DAO.repositories;

import ma.petproject.petproject.DAO.entities.Act;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActRepository extends JpaRepository<Act,Integer> {
}
