package com.udacity.bootstrap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogBreed;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogName;
import com.udacity.bootstrap.services.DogService;

@RestController
@RequestMapping("/dogs")
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/breeds")
    public ResponseEntity<List<DogBreed>> getAllDogBreeds() {
        List<DogBreed> dogBreeds = dogService.retrieveDogBreeds();
        return new ResponseEntity<>(dogBreeds, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<DogName>> getAllDogNames() {
        List<DogName> dogNames = dogService.retrieveDogNames();
        return new ResponseEntity<>(dogNames, HttpStatus.OK);
    }

    @GetMapping("/breeds/{dogId}")
    public ResponseEntity<DogBreed> getDogBreedById (@PathVariable long dogId) {
        DogBreed dogBreed = dogService.retrieveDogBreedById(dogId);
        if (dogBreed == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DogBreed>(dogBreed, HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Dog>> all() {
        return new ResponseEntity<Iterable<Dog>>(dogService.all(), HttpStatus.OK);
    }
}
