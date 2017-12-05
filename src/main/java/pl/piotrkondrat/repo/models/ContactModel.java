package pl.piotrkondrat.repo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "contact")
public class ContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact_value")
    private String contactValue;

    @ManyToOne
    @JoinColumn (name = "person_id")
    private PersonModel personId;
}
