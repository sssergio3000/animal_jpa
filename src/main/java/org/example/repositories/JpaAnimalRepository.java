package org.example.repositories;

import org.example.entity.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class JpaAnimalRepository implements IAnimalRepository{

    private final EntityManagerFactory emf;
    private EntityManager em;

    public JpaAnimalRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Animal create(Animal animal) {
        System.out.println("\nStart of CREATE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
        em.close();
        System.out.println("End of CREATE...");
        return animal;
    }

    @Override
    public Animal read(int id) {
        System.out.println("\nStart of READ...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        em.close();
        System.out.println("End of READ...");
        return animal;
    }

    @Override
    public void update(Animal animal) {
        System.out.println("\nStart of UPDATE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        em.close();
        System.out.println("End of UPDATE...");
    }

    @Override
    public void delete(Animal animal) {
        System.out.println("\nStart of DELETE...");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        em.remove(em.contains(animal) ? animal : em.merge(animal));

        em.getTransaction().commit();
        em.close();
        System.out.println("End of DELETE...");
    }

    @Override
    public List<Animal> getAll() {
        System.out.println("\nStart of GET ALL...");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT animal FROM Animal animal");
//        Query query = em.createQuery("FROM Client"); // doesn't work in EclipseLink
        List<Animal> animals = query.getResultList();
        em.getTransaction().commit();
        em.close();
        System.out.println("End of GET ALL...");
        return animals;

    }
}
