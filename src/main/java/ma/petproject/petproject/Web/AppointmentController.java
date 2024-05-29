package ma.petproject.petproject.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {
    @GetMapping("/ListAppointments")
    public String ListVeterinarian() {
        return "AdminInterface/Appointment/ListAppointments";
    }
    @GetMapping("/DeleteAppointment")
    public String DeleteAppointment() {
        return "AdminInterface/Appointment/DeleteAppointment";
    }
    @GetMapping("/AddAppointment")
    public String AddAppointment() {
        return "AdminInterface/Appointment/AddAppointment";
    }

}
