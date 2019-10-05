package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Band;

public class BandHelper {

	static EntityManagerFactory	emfactory = Persistence.createEntityManagerFactory("BandProject");

	public void insertBand(Band b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	public Band searchForBandByID(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Band found = em.find(Band.class,  idToEdit);
		em.close();
		return found;
	}
	
	public void updateBand(Band toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Band> searchForBandByName(String bandName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery	= em.createQuery(
				"select b from Band li	where b.bandName	= :selectedBand", Band.class);
		typedQuery.setParameter("selectedBand", bandName);
		List<Band> foundItems = typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public void deleteBand(Band toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band>typedQuery = em.createQuery(
				"select li from ListItem li	where li.title = "
				+ ":selectedTitle and li.author = :selectedAuthor", Band.class);
		//Substitute parameter with	actual data	from the toDelete item
		typedQuery.setParameter("selectedBand", toDelete.getBandName());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a	new	list item
		Band result	= typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

}
