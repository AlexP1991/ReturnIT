package com.example.demo.service;

import com.example.demo.model.dtos.PersonDTO;
import com.example.demo.model.entity.Person;
import com.example.demo.repo.PersonRepo;
import com.example.demo.service.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    private final PersonMapper personMapper=new PersonMapper();
    public void save(PersonDTO personDTO){
        Person person = personMapper.toEntity(personDTO);
        personRepo.save(person);
    }
    public List<PersonDTO> findAll(){
        List<Person> personList= personRepo.findAll();
        return personList.stream().map(personMapper::toDTO).toList();
    }
    public PersonDTO findById(long ID){
        Person person= personRepo.findById(ID).orElseThrow(() -> new RuntimeException("Person with ID "+ID+" Not found"));
        return personMapper.toDTO(person);
    }
    public void update(long ID, PersonDTO personDTO){
        Person person= personRepo.findById(ID).orElseThrow(() -> new RuntimeException("Person with ID "+ID+" Not found"));
        person.setPersonName(personDTO.getPersonName());
        //person.setInventoryName(personDTO.getInvetoryName());
        personRepo.save(person);
    }
    public void deleteById(long ID){
        Person person= personRepo.findById(ID).orElseThrow(() -> new RuntimeException("Person with ID "+ID+" Not found"));
        personRepo.deleteById(ID);
    }
    public void deleteAll(){
        personRepo.deleteAll();
    }
}
