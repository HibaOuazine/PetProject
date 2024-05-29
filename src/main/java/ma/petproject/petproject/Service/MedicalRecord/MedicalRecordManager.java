package ma.petproject.petproject.Service.MedicalRecord;




import ma.petproject.petproject.DAO.entities.MedicalRecord;

import java.util.List;

public interface MedicalRecordManager {
    MedicalRecord addMedicalRecord(MedicalRecord medicalRecord);

    boolean removeMedicalRecord(MedicalRecord medicalRecord);

    boolean removeMedicalRecordById(Integer id);

    MedicalRecord getMedicalRecordById(Integer id);

    MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);

    List<MedicalRecord> getAllMedicalRecords();
}
