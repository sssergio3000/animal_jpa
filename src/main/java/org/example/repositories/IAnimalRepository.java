package org.example.repositories;

import org.example.entity.Animal;

import java.util.List;

public interface IAnimalRepository {

    Animal create(Animal animal);

    Animal read(int id);

    void update (Animal animal);

    void delete(Animal animal);

    List<Animal> getAll ();



}
