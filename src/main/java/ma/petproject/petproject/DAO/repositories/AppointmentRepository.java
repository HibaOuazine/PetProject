package ma.petproject.petproject.DAO.repositories;

import ma.petproject.petproject.DAO.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
