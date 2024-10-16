package com.example.create_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.create_api.models.Person;
import com.example.create_api.repository.PersonRepository;



@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    //CONSEGUIR TODOS LOS NOMBRES DE LA LISTA USERS
    @GetMapping("/persons")
    public List<Person> getAllPerson(){
        return repository.findAll();
    }


    //CONSEGUIR PERSONA POR NOMBRE
    @GetMapping("/person/{name}")
    public List<Person> findByName(@PathVariable("name") String name){
        return repository.findByName(name);
    }

    //CREAR PERSONA
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return repository.save(person);
    }

    //ACTULIZAR/EDITAR PERSONA
    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        return repository.save(person);
    }

    //BORRAR PERSONA
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
    
    @GetMapping("/get-person")
    public String getPerson(){
        return "Conseguir persona";
    }
}
