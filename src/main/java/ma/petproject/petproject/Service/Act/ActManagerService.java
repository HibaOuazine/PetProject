package ma.petproject.petproject.Service.Act;

import ma.petproject.petproject.DAO.entities.Act;
import ma.petproject.petproject.DAO.repositories.ActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ActManagerService implements ActManager {

    @Autowired
    private ActRepository actRepository;

    @Override
    public Act addAct(Act act) {
        return actRepository.save(act);
    }

    @Override
    public Boolean removeAct(Act act) {
        try {
            actRepository.delete(act);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public Boolean removeActById(Integer id) {
        try {
            actRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Act getActById(Integer id) {
        return actRepository.findById(id).orElse(null);
    }

    @Override
    public Act updateAct(Act act) {
        if (actRepository.existsById(act.getId())) {
            return actRepository.save(act);
        } else {
            return null;
        }
    }

    @Override
    public List<Act> getAllActs() {
        return actRepository.findAll();
    }
}
