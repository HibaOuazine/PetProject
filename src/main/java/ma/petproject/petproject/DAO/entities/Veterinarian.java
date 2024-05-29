package ma.petproject.petproject.DAO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Veterinarian")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veterinarian
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private String firstName;
    private String lastName;
    private String specialty;
    private String description;
    private String email;
    private String phoneNumber;

    @OneToMany( cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

}
