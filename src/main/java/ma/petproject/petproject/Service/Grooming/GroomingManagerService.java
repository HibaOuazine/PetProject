package ma.petproject.petproject.Service.Grooming;


import ma.petproject.petproject.DAO.entities.Grooming;
import ma.petproject.petproject.DAO.repositories.GroomingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class GroomingManagerService implements GroomingManager {

    @Autowired
    private GroomingRepository groomingRepository;

    @Override
    public Grooming addGrooming(Grooming grooming) {
        return groomingRepository.save(grooming);
    }

    @Override
    public boolean removeGrooming(Grooming grooming) {
        try {
            groomingRepository.delete(grooming);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @Override
    public boolean removeGroomingById(Integer id) {
        try {
            groomingRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Grooming getGroomingById(Integer id) {
        return groomingRepository.findById(id).orElse(null);
    }

    @Override
    public Grooming updateGrooming(Grooming grooming) {
        if (groomingRepository.existsById(grooming.getId())) {
            return groomingRepository.save(grooming);
        } else {
            return null;
        }
    }

    @Override
    public List<Grooming> getAllGroomings() {
        return groomingRepository.findAll();
    }
}
