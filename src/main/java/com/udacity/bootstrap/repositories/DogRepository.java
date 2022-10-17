package com.udacity.bootstrap.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogBreed;
import com.udacity.bootstrap.repositories.DTOinterfaces.DogName;

public interface DogRepository extends CrudRepository<Dog, Long> {
    Optional<Dog> findById(long id);
    @Query(value = "select d.id, d.breed from dog as d", nativeQuery = true)
    List<DogBreed> findAllDogBreeds();
    @Query(value = "select d.id, d.name from dog as d", nativeQuery = true)
    List<DogName> findAllDogNames();
    @Query(value = "select d.id, d.breed from dog as d where id=?1", nativeQuery = true)
    DogBreed findDogBreedById(long id);
    // @Query("select d.id, d.breed from Dog d")
    // List<DogBreed> findAllDogBreeds();
    // @Query("select d.id, d.name from Dog d")
    // List<DogName> findAllDogNames();
    // @Query("select d.id, d.breed from Dog d where d.id=:id")
    // DogBreed findDogBreedById(long id);
}
