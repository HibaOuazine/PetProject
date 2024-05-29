package ma.petproject.petproject.DAO.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name ="Consultation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation extends Act {

    @Temporal(TemporalType.DATE)
    private Date date;

    private String symptom;
    private String treatment;

}
