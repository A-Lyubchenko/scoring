package com.scoring.mywallet.domains;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "additional_contact")
public class AdditionalContact {
    @Id
    @Column(name = "additional_contact_id")
    private UUID id = UUID.randomUUID();
    @Column(name = "contact")
    private String contact;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "telephone_number")
    private int telephoneNumber;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;




}
