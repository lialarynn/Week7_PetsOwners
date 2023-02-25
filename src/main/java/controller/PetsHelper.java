/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Feb 24, 2023
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pets;

public class PetsHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetsOwners");
	
	public void insertPets(Pets p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		System.out.println("Pet has been added");
	}
}
