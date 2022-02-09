package com.scoring.mywallet.domains;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "person_id")
    private UUID id = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "marital")
    private String marital;
    @Column(name = "dependents_amount")
    private int dependentsAmount;
    @Column(name = "telephone_number")
    private int telephoneNumber;


    @OneToMany(mappedBy = "id", fetch =FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<AdditionalContact> additionalContact;


}
