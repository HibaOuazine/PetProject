package ma.petproject.petproject.Service.Act;

import ma.petproject.petproject.DAO.entities.Act;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActManager {

    Act addAct(Act act);

    Boolean removeAct(Act act);

    Boolean removeActById(Integer id);

    Act getActById(Integer id);

    Act updateAct(Act act);

    List<Act> getAllActs();
}
