package ma.petproject.petproject.Service.Consultation;


import ma.petproject.petproject.DAO.entities.Consultation;
import ma.petproject.petproject.DAO.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ConsultationManagerService implements ConsultationManager {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public Consultation addConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public boolean removeConsultation(Consultation consultation) {
        try {
            consultationRepository.delete(consultation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @Override
    public boolean removeConsultationById(Integer id) {
        try {
            consultationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Consultation getConsultationById(Integer id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation updateConsultation(Consultation consultation) {
        if (consultationRepository.existsById(consultation.getId())) {
            return consultationRepository.save(consultation);
        } else {
            return null;
        }
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
}
