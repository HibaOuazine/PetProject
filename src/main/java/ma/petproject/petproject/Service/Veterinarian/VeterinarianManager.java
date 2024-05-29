package ma.petproject.petproject.Service.Veterinarian;


import ma.petproject.petproject.DAO.entities.Veterinarian;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VeterinarianManager
{
    Veterinarian addVeterinarian(Veterinarian veterinarian);

    Boolean removeVeterinarian(Veterinarian veterinarian);

    Boolean removeVeterinarianByID(Integer id);

    Veterinarian getVeterinarianById(Integer id);

    Veterinarian updateVeterinarian(Veterinarian veterinarian);

    List<Veterinarian> getAllVeterinarians();
}
