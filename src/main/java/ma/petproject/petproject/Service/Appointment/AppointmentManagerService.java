package ma.petproject.petproject.Service.Appointment;



import ma.petproject.petproject.DAO.entities.Appointment;
import ma.petproject.petproject.DAO.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class AppointmentManagerService implements AppointmentManager {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Boolean removeAppointment(Appointment appointment) {
        try {
            appointmentRepository.delete(appointment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @Override
    public Boolean removeAppointmentById(Integer id) {
        try {
            appointmentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Appointment getAppointmentById(Integer id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        if (appointmentRepository.existsById(appointment.getId())) {
            return appointmentRepository.save(appointment);
        } else {
            return null;
        }
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
