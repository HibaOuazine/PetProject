package ma.petproject.petproject.Service.Veterinarian;


import ma.petproject.petproject.DAO.entities.Veterinarian;
import ma.petproject.petproject.DAO.repositories.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class VeterinarianManagerService implements VeterinarianManager {


    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Override
    public Veterinarian addVeterinarian(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    @Override
    public Boolean removeVeterinarian(Veterinarian veterinarian) {
        try {
            veterinarianRepository.delete(veterinarian);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @Override
    public Boolean removeVeterinarianByID(Integer id) {
        try {
            veterinarianRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Veterinarian getVeterinarianById(Integer id) {
        return veterinarianRepository.findById(id).get();
    }

    @Override
    public Veterinarian updateVeterinarian(Veterinarian veterinarian) {

        if (veterinarianRepository.existsById(veterinarian.getId())) {

            return veterinarianRepository.save(veterinarian);
        } else {

            return null;
        }
    }


    @Override
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

}
