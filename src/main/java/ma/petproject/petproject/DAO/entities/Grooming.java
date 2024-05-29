package ma.petproject.petproject.DAO.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Grooming")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grooming extends Act {

    private String groomingType;
    private boolean nailTrimming;
    private boolean bathing;

}
