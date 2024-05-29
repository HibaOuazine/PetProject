package ma.petproject.petproject.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicalRecordController {

    @GetMapping("/ListMedicalRecords")
    public String ListVeterinarian() {
        return "AdminInterface/MedicalRecord/ListMedicalRecords";
    }
    @GetMapping("/DeleteMedicalRecord")
    public String DeleteMedicalRecord() {
        return "AdminInterface/MedicalRecord/DeleteMedicalRecord";
    }
    @GetMapping("/AddMedicalRecord")
    public String AddMedicalRecord() {
        return "AdminInterface/MedicalRecord/AddMedicalRecord";
    }

}
