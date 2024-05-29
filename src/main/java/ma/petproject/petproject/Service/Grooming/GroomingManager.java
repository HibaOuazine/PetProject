package ma.petproject.petproject.Service.Grooming;




import ma.petproject.petproject.DAO.entities.Grooming;

import java.util.List;

public interface GroomingManager {

    Grooming addGrooming(Grooming grooming);

    boolean removeGrooming(Grooming grooming);

    boolean removeGroomingById(Integer id);

    Grooming getGroomingById(Integer id);

    Grooming updateGrooming(Grooming grooming);

    List<Grooming> getAllGroomings();
}
