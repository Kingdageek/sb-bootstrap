package com.udacity.bootstrap.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repositories.DogRepository;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogBreed;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogName;
import com.udacity.bootstrap.services.DogService;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<DogBreed> retrieveDogBreeds() {
        return dogRepository.findAllDogBreeds();
    }

    @Override
    public DogBreed retrieveDogBreedById(long dogId) {
        return dogRepository.findDogBreedById(dogId);
    }

    @Override
    public List<DogName> retrieveDogNames() {
        return dogRepository.findAllDogNames();
    }

    @Override
    public Iterable<Dog> all() {
        return dogRepository.findAll();
    }
    
}
