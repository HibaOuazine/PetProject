package ma.petproject.petproject.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController
{

    @GetMapping("/signin")
    public String SignIn() {
        return "AdminInterface/signin";
    }

    @GetMapping("/index")
    public String index() {
        return "UserInterface/index";
    }


}
