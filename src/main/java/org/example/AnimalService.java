package org.example;

import org.example.entity.Animal;
import org.example.repositories.IAnimalRepository;

import java.util.List;

public class AnimalService {
    private final IAnimalRepository animalRepository;

    public AnimalService(IAnimalRepository animalRepository) {

        this.animalRepository = animalRepository;


    }
    public void run() {
//        create();
//        read(1);
//        update();
//        delete(1);
        getAll();
    }

    public void create() {
        Animal newAnimal = new Animal("Mopsik", 7, false);
        System.out.println(newAnimal); // id == 0
        Animal persistedAnimal = animalRepository.create(newAnimal);
        System.out.println(persistedAnimal); // id is taken from DB
    }

    public void read(int id) {
        Animal animalFromDb = animalRepository.read(id);
        System.out.println(animalFromDb);
    }

    public void update() {
        Animal animalToUpdate = animalRepository.read(1);
        animalToUpdate.setName("Tuzikkk");
        animalToUpdate.setAge(999);
        animalRepository.update(animalToUpdate);
    }

    public void delete(int id) {
        Animal animalToDelete = animalRepository.read(id);
        animalRepository.delete(animalToDelete);
    }

    public void getAll() {
        List<Animal> animals = animalRepository.getAll();
        animals.forEach(System.out::println);
    }
}
