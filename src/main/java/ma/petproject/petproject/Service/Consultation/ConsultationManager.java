package ma.petproject.petproject.Service.Consultation;



import ma.petproject.petproject.DAO.entities.Consultation;

import java.util.List;

public interface ConsultationManager {

    Consultation addConsultation(Consultation consultation);

    boolean removeConsultation(Consultation consultation);

    boolean removeConsultationById(Integer id);

    Consultation getConsultationById(Integer id);

    Consultation updateConsultation(Consultation consultation);

    List<Consultation> getAllConsultations();
}
