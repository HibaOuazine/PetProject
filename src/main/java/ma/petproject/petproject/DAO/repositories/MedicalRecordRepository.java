package ma.petproject.petproject.DAO.repositories;


import ma.petproject.petproject.DAO.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer> {
}
