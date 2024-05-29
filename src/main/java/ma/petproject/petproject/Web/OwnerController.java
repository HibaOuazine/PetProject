package ma.j2e.j2e.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    @GetMapping("/ListOwners")
    public String ListVeterinarian() {
        return "AdminInterface/Owner/ListOwners";
    }
    @GetMapping("/DeleteOwner")
    public String DeleteOwner() {
        return "AdminInterface/Owner/DeleteOwner";
    }
    @GetMapping("/AddOwner")
    public String AddOwner() {
        return "AdminInterface/Owner/AddOwner";
    }

}
