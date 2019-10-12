package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Album;
import model.Band;
import model.BandMembers;

public class BandHelper {

	static EntityManagerFactory	emfactory = Persistence.createEntityManagerFactory("BandProject");

	public void insertBand(Band b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Band> showAllBands() {
		EntityManager em = emfactory.createEntityManager();
		//List<Band> allItems = em.createNamedQuery("Band.findBands", Band.class).getResultList();
		List<Band> allItems = em.createQuery("SELECT b FROM Band b").getResultList();
		//Testing to see if @NamedQuery worked for get list of bands
		for (Band b: allItems) {
			System.out.println(b.getBandId());
			System.out.println(b.getBandName());
		}
		
		return allItems;
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
				"select b from Band b where b.bandName = :selectedBand", Band.class);
		typedQuery.setParameter("selectedBand", bandName);
		List<Band> foundItems = typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public Band searchForOneBandByName(String bandName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery	= em.createQuery(
				"select b from Band b where b.bandName = :selectedBand", Band.class);
		typedQuery.setParameter("selectedBand", bandName);
		Band foundBand = typedQuery.getSingleResult();
		em.close();
		return	foundBand;
	}
	
	public void deleteBand(Band toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
//		System.out.println("Here is the toDelete object info: " + toDelete.getBandId() + " " + toDelete.getBandName());
//		
//		// Album start ->
//		// Set up Album object
//		Album a = new Album();
//		a.setAlbumId(toDelete.getBandId());
//		//Query DB
//		TypedQuery<Album>typedAlbumQuery = em.createQuery("select a from Album a where a.bandId = :selectedAlbum", Album.class);
//		typedAlbumQuery.setParameter("selectedAlbum", Integer.toString(a.getAlbumId()));
//		typedAlbumQuery.setMaxResults(1);
//		Album albumResult = typedAlbumQuery.getSingleResult();
//		em.remove(albumResult);
//		// <- Album end
//		
//		// BandMember start ->
//		TypedQuery<BandMembers>typedMemberQuery = em.createQuery("select bm from BandMembers bm where bm.bandId = :selectedMember", BandMembers.class);
//		typedMemberQuery.setParameter("selectedMember", Integer.toString(toDelete.getBandId()));
//		typedMemberQuery.setMaxResults(1);
//		BandMembers memberResult = typedMemberQuery.getSingleResult();
//		em.remove(memberResult);
//		// <- BandMember end
		
		// Band start ->
		TypedQuery<Band>typedBandQuery = em.createQuery(
				"select b from Band b where b.bandName = :selectedBand", Band.class);
		//Substitute parameter with	actual data	from the toDelete item
		typedBandQuery.setParameter("selectedBand", toDelete.getBandName());
		//we only want one result
		typedBandQuery.setMaxResults(1);
		//get the result and save it into a	new	list item
		Band result	= typedBandQuery.getSingleResult();
		//remove it
		em.remove(result);
		// <- Band End
		
		em.getTransaction().commit();
		em.close();
	}

}
