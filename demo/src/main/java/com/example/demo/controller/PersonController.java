package com.example.demo.controller;

import com.example.demo.model.dtos.PersonDTO;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    @PostMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody PersonDTO personDTO){
        personService.save(personDTO);
        return ResponseEntity.ok("person added successfully");
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<PersonDTO>> findAll(){
        List<PersonDTO> personDTOList= personService.findAll();
        return ResponseEntity.ok(personDTOList);
    }
    @GetMapping("/findById/{ID}")
    public ResponseEntity<?> findById(@PathVariable long ID){
        try {
            PersonDTO personDTO=personService.findById(ID);
            return new ResponseEntity<>(personDTO, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updatePerson/{ID}")
    public ResponseEntity<String> updatePerson(@PathVariable long ID,@RequestBody PersonDTO personDTO){
        try{
            personService.update(ID,personDTO);
            return ResponseEntity.ok("person with ID "+ID+" updated successfully");
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deletePerson/{ID}")
    public ResponseEntity<String> deletePerson(@PathVariable long ID){
        try {
            personService.deleteById(ID);
            return ResponseEntity.ok("person with ID "+ID+" deleted successfully");
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        personService.deleteAll();
        return ResponseEntity.ok("all persons were deleted");
    }

}
