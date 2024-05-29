package ma.petproject.petproject.Web;


import ma.petproject.petproject.DAO.entities.Animal;
import ma.petproject.petproject.Service.Animal.AnimalManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class AnimalController {

    @Autowired
    private AnimalManagerService animalManagerService;


    @GetMapping("/ListAnimals")
    public String listAnimals(Model model) {
        List<Animal> animals = animalManagerService.getAllAnimals();
        model.addAttribute("Animal", animals);
        return "AdminInterface/Animal/ListAnimals";
    }


    @GetMapping("/DeleteAnimal")
    public String DeleteAnimal() {
        return "AdminInterface/Animal/DeleteAnimal";
    }
    @GetMapping("/AddAnimal")
    public String AddAnimal() {
        return "AdminInterface/Animal/AddAnimal";
    }


}
