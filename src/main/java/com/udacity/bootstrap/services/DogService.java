package com.udacity.bootstrap.services;

import java.util.List;

import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogBreed;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogName;

public interface DogService {
    
    public List<DogBreed> retrieveDogBreeds();
    public DogBreed retrieveDogBreedById(long dogId);
    public List<DogName> retrieveDogNames();
    public Iterable<Dog> all();
}
