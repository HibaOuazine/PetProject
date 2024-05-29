package ma.petproject.petproject.Service.Owner;


import ma.petproject.petproject.DAO.entities.Owner;
import ma.petproject.petproject.DAO.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class OwnerManagerService implements OwnerManager {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public boolean removeOwner(Owner owner) {
        try {
            ownerRepository.delete(owner);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @Override
    public boolean removeOwnerById(Integer id) {
        try {
            ownerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Owner getOwnerById(Integer id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner updateOwner(Owner owner) {
        if (ownerRepository.existsById(owner.getId())) {
            return ownerRepository.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
}
