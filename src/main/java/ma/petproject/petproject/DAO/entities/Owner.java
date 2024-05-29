package ma.petproject.petproject.DAO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Animal> animals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();
}
