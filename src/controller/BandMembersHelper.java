package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Band;
import model.BandMembers;

public class BandMembersHelper {
	static EntityManagerFactory	emfactory = Persistence.createEntityManagerFactory("BandProject");

	public void insertBandMember(BandMembers b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BandMembers> showAllBandMemberss() {
		EntityManager em = emfactory.createEntityManager();
		List<BandMembers> allItems = em.createQuery("SELECT bm FROM BandMembers bm").getResultList();
		return allItems;
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
	
	public void updateBandMember(BandMembers toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BandMembers> searchForBandMemberByName(String memberName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BandMembers> typedQuery	= em.createQuery(
				"select bm from BandMembers bm	where bm.memberName	= :selectedBandMember", BandMembers.class);
		typedQuery.setParameter("selectedBandMembers", memberName);
		List<BandMembers> foundItems = typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public void deleteBandMember(BandMembers toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BandMembers>typedQuery = em.createQuery(
				"select li from ListItem li	where li.title = "
				+ ":selectedTitle and li.author = :selectedAuthor", BandMembers.class);
		//Substitute parameter with	actual data	from the toDelete item
		typedQuery.setParameter("selectedBand", toDelete.getMemberName());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a	new	list item
		BandMembers result	= typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
