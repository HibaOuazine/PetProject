package ma.petproject.petproject.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActController
{
    @GetMapping("/ListActs")
    public String ListActs() {
        return "AdminInterface/Act/ListActs";
    }
    @GetMapping("/DeleteAct")
    public String DeleteAct() {
        return "AdminInterface/Act/DeleteAct";
    }
    @GetMapping("/AddAct")
    public String AddAct() {
        return "AdminInterface/Act/AddAct";
    }

}
