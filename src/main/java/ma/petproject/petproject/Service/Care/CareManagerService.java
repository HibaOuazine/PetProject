package ma.petproject.petproject.Service.Care;


import ma.petproject.petproject.DAO.entities.Care;
import ma.petproject.petproject.DAO.repositories.CareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CareManagerService implements CareManager {

    @Autowired
    private CareRepository careRepository;

    @Override
    public Care addCare(Care care) {
        return careRepository.save(care);
    }

    @Override
    public Boolean removeCare(Care care) {
        try {
            careRepository.delete(care);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public Boolean removeCareById(Integer id) {
        try {
            careRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Care getCareById(Integer id) {
        return careRepository.findById(id).orElse(null);
    }

    @Override
    public Care updateCare(Care care) {
        if (careRepository.existsById(care.getId())) {
            return careRepository.save(care);
        } else {
            return null;
        }
    }

    @Override
    public List<Care> getAllCares() {
        return careRepository.findAll();
    }
}
