package ma.petproject.petproject.Web;


import jakarta.validation.Valid;
import ma.petproject.petproject.DAO.entities.Veterinarian;
import ma.petproject.petproject.Service.Veterinarian.VeterinarianManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class VeterinarianController {
    private static final Logger logger = LoggerFactory.getLogger(VeterinarianController.class);

    @Autowired
    private VeterinarianManagerService veterinarianManagerService;

    @Value("${upload.directory}")
    private String uploadDirectory;

    @GetMapping("/ListVeterinarians")
    public String listVeterinarians(Model model) {
        List<Veterinarian> veterinarians = veterinarianManagerService.getAllVeterinarians();
        model.addAttribute("veterinarians", veterinarians);
        return "AdminInterface/Veterinarian/ListVeterinarians";
    }

    @GetMapping("")
    public String start() {
        return "redirect:/sign";
    }

    @GetMapping("/DeleteVeterinarian/{id}")
    public String deleteVeterinarian(@PathVariable Integer id) {
        boolean removed = veterinarianManagerService.removeVeterinarianByID(id);
        return "redirect:/ListVeterinarians";
    }

    @GetMapping("/AddVeterinarian")
    public String showAddVeterinarianForm(Model model) {
        model.addAttribute("veterinarian", new Veterinarian());
        return "AdminInterface/Veterinarian/AddVeterinarian";
    }

    @PostMapping("/AddVeterinarianOnce")
    public String addVeterinarianOnce(Model model,
                                @Valid Veterinarian veterinarian,
                                BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/ListVeterinarians" ;
        }
        veterinarianManagerService.addVeterinarian(veterinarian);
        return "redirect:ListVeterinarians";
    }



    @PostMapping("/AddVeterinarian")
    public String addVeterinarian(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("specialty") String specialty,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("image") MultipartFile image,
            RedirectAttributes redirectAttributes
    ) {
        try {
            Veterinarian veterinarian = new Veterinarian();
            veterinarian.setFirstName(firstName);
            veterinarian.setLastName(lastName);
            veterinarian.setSpecialty(specialty);
            veterinarian.setDescription(description);
            veterinarian.setEmail(email);
            veterinarian.setPhoneNumber(phoneNumber);

            if (!image.isEmpty()) {
                String uuid = UUID.randomUUID().toString();
                String originalFileName = image.getOriginalFilename();
                String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
                String newFileName = uuid + extension;
                String filePath = uploadDirectory + newFileName;

                image.transferTo(new File(filePath));
                veterinarian.setImage(newFileName);
            }

            veterinarianManagerService.addVeterinarian(veterinarian);
            redirectAttributes.addFlashAttribute("message", "Veterinarian added successfully.");
            return "redirect:/ListVeterinarians";
        } catch (IOException e) {
            logger.error("Failed to upload image while adding Veterinarian: {}", e.getMessage());
            redirectAttributes.addFlashAttribute("error", "Failed to upload image.");
            return "redirect:/AddVeterinarian";
        }
    }

    @GetMapping("/editVeterinarian")
    public String editVeterinarian(Model model, @RequestParam(name = "id") Integer id) {
        Veterinarian veterinarian = veterinarianManagerService.getVeterinarianById(id);
        if (veterinarian != null) {
            model.addAttribute("veterinarianToBeUpdated", veterinarian);
            return "AdminInterface/Veterinarian/UpdateVeterinarian"; // Correction ici
        } else {
            return "redirect:/ListVeterinarians";
        }
    }

    @PostMapping("/updateVeterinarian")
    public String updateVeterinarian(
            @RequestParam("id") Integer id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("specialty") String specialty,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("image") MultipartFile image,
            RedirectAttributes redirectAttributes
    ) {
        try {
            // Récupérez le vétérinaire existant
            Veterinarian veterinarian = veterinarianManagerService.getVeterinarianById(id);
            if (veterinarian == null) {
                redirectAttributes.addFlashAttribute("error", "Veterinarian not found.");
                return "redirect:/ListVeterinarians";
            }

            // Mettez à jour les champs du vétérinaire
            veterinarian.setFirstName(firstName);
            veterinarian.setLastName(lastName);
            veterinarian.setSpecialty(specialty);
            veterinarian.setDescription(description);
            veterinarian.setEmail(email);
            veterinarian.setPhoneNumber(phoneNumber);

            // Si une nouvelle image est téléchargée, mettez à jour le champ image
            if (!image.isEmpty()) {
                String uuid = UUID.randomUUID().toString();
                String originalFileName = image.getOriginalFilename();
                String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
                String newFileName = uuid + extension;
                String filePath = uploadDirectory + newFileName;

                image.transferTo(new File(filePath));
                veterinarian.setImage(newFileName);
            }

            // Appelez la méthode updateVeterinarian pour sauvegarder les modifications
            veterinarianManagerService.updateVeterinarian(veterinarian);
            redirectAttributes.addFlashAttribute("message", "Veterinarian updated successfully.");
            return "redirect:/ListVeterinarians";
        } catch (IOException e) {
            logger.error("Failed to upload image while updating Veterinarian: {}", e.getMessage());
            redirectAttributes.addFlashAttribute("error", "Failed to upload image.");
            return "redirect:/editVeterinarian?id=" + id;
        }
    }
}
