package com.example.demo.service.mappers;

import com.example.demo.model.dtos.PersonDTO;
import com.example.demo.model.entity.Person;

public class PersonMapper {
    public Person toEntity (PersonDTO personDTO){
        Person person=new Person();
        person.setPersonName(personDTO.getPersonName());
        //person.setInventoryName(personDTO.getInventoryName());
        return person;
    }
    public PersonDTO toDTO (Person person){
        PersonDTO personDTO=new PersonDTO();
        personDTO.setPersonName(person.getPersonName());
        //personDTO.setInventoryName(person.getInventoryName());
        return personDTO;
    }
}
