package pl.piotrkondrat.repo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name="person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstname;

    private String lastname;

    private String gender;

    @OneToMany(mappedBy = "personId", cascade = CascadeType.ALL)
    private List<ContactModel> contacts;


}
