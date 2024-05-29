package ma.petproject.petproject.Service.Owner;




import ma.petproject.petproject.DAO.entities.Owner;

import java.util.List;

public interface OwnerManager {
    Owner addOwner(Owner owner);
    boolean removeOwner(Owner owner);
    boolean removeOwnerById(Integer id);
    Owner getOwnerById(Integer id);
    Owner updateOwner(Owner owner);
    List<Owner> getAllOwners();
}
