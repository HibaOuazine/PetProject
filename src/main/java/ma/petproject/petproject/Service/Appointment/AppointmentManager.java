package ma.petproject.petproject.Service.Appointment;



import ma.petproject.petproject.DAO.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentManager {

    Appointment addAppointment(Appointment appointment);

    Boolean removeAppointment(Appointment appointment);

    Boolean removeAppointmentById(Integer id);

    Appointment getAppointmentById(Integer id);

    Appointment updateAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();
}
