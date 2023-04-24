package org.example;

import org.example.repositories.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa");
        IAnimalRepository animalRepository = new JpaAnimalRepository(emf);
        AnimalService animalService = new AnimalService(animalRepository);

        animalService.run();


    }
}