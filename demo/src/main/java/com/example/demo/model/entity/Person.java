package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Table(name="person")
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String personName;
    //private String inventoryName
    //Facem Getter si Setter
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

}
