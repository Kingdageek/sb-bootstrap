package com.udacity.bootstrap.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String breed;
    private String origin;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Dog() {}

    // public Dog(long id, String name, String breed, String origin) {
    //     this.id = id;
    //     this.name = name;
    //     this.breed = breed;
    //     this.origin = origin;
    // }

    // public void setId(long id) {
    //     this.id = id;
    // }

    // public long getId() {
    //     return id;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setBreed(String breed) {
    //     this.breed = breed;
    // }

    // public String getBreed() {
    //     return breed;
    // }

    // public void setOrigin (String origin) {
    //     this.origin = origin;
    // }

    // public String getOrigin() {
    //     return origin;
    // }
}
