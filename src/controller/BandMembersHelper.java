package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.BandMembers;

public class BandMembersHelper {
	static EntityManagerFactory	emfactory = Persistence.createEntityManagerFactory("BandProject");

	public void insertBand(BandMembers b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	public BandMembers searchForBandByID(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BandMembers found = em.find(BandMembers.class,  idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(BandMembers toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
