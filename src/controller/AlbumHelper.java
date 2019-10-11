package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Album;
import model.Band;

public class AlbumHelper {
	static EntityManagerFactory	emfactory = Persistence.createEntityManagerFactory("BandProject");

	public void insertAlbum(Album a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Album> showAllAlbums() {
		EntityManager em = emfactory.createEntityManager();
		List<Album> allItems = em.createQuery("SELECT a FROM Album a").getResultList();
		
		// The below list was an attempt to join tables without an annotated entity in model package,
		// but after trying to figure out how to access all of the attributes, I have realized there is 
		// not time to continue this. Will leave it basic for now.
//		List<Album> allItems = em.createQuery("SELECT a, b FROM Album a, Band b").getResultList();
		
		// The below is to test and see the list in console
		System.out.println("Query works");
		System.out.println(allItems);
		
		for (Album b: allItems) {
			System.out.println("     -----     ");
			System.out.println(b.getAlbumId());
			System.out.println(b.getAlbumName());
			System.out.println(b.toString());
			System.out.println("---------------");
		}
		
		return allItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	public Album searchForAlbumByID(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Album found = em.find(Album.class,  idToEdit);
		em.close();
		return found;
	}
	
	public void updateAlbum(Album toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
