/**
 * @author Lia Kruger - alkruger2
 * CIS175 - Spring 2023
 * Feb 25, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Owners;

public class OwnersHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetsOwners");
	
	public void insertOwners(Owners o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
		System.out.println("Owner has been added");
	}

	/**
	 * @return
	 */
	public List<Owners> showAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<Owners> allOwners = em.createQuery("SELECT o FROM Owners o").getResultList();
		System.out.println(allOwners.size() + " owners have been found.");
		return allOwners;
	}

	/**
	 * @param tempId
	 * @return
	 */
	public Owners searchOwnerByID(Integer ownerId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Owners owner = em.find(Owners.class, ownerId);
		em.close();
		System.out.println(owner.getName() + " has been found.");
		return owner;
	}

	/**
	 * @param ownerToDelete
	 */
	public void deleteOwner(Owners ownerToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		if (!em.contains(ownerToDelete)) {
			ownerToDelete = em.merge(ownerToDelete);
		}
		
		em.remove(ownerToDelete);
		em.getTransaction().commit();
		em.close();
		System.out.println(ownerToDelete.getName() + " has been deleted.");
	}

	/**
	 * @param ownerToUpdate
	 */
	public void updateOwner(Owners ownerToUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(ownerToUpdate);
		em.getTransaction().commit();
		em.close();
		System.out.println(ownerToUpdate.getName() + " has been updated.");
	}

	/**
	 * @return
	 */
	public List<Owners> getOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<Owners> allOwners = em.createQuery("SELECT o FROM Owners o").getResultList();
		return allOwners;
		
	}
}