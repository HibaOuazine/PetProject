package ma.petproject.petproject.Service.Care;


import ma.petproject.petproject.DAO.entities.Care;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CareManager {

    Care addCare(Care care);

    Boolean removeCare(Care care);

    Boolean removeCareById(Integer id);

    Care getCareById(Integer id);

    Care updateCare(Care care);

    List<Care> getAllCares();
}
