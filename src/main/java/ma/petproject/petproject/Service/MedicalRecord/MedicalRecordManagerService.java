package ma.petproject.petproject.Service.MedicalRecord;


import ma.petproject.petproject.DAO.entities.MedicalRecord;
import ma.petproject.petproject.DAO.repositories.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MedicalRecordManagerService implements MedicalRecordManager {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public boolean removeMedicalRecord(MedicalRecord medicalRecord) {
        try {
            medicalRecordRepository.delete(medicalRecord);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    @Override
    public boolean removeMedicalRecordById(Integer id) {
        try {
            medicalRecordRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MedicalRecord getMedicalRecordById(Integer id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    @Override
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        if (medicalRecordRepository.existsById(medicalRecord.getId())) {
            return medicalRecordRepository.save(medicalRecord);
        } else {
            return null;
        }
    }

    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }
}
