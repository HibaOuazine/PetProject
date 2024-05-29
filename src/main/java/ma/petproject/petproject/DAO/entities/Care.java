package ma.petproject.petproject.DAO.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Care")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Care extends Act {

    private String careType;
    private String description;
    private boolean medicalPrescription;

}
