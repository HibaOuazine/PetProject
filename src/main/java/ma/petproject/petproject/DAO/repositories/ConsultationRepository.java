package ma.petproject.petproject.DAO.repositories;



import ma.petproject.petproject.DAO.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {
}
