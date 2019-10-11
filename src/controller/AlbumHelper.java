package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Album;

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
//		List<Album> allItems = em.createQuery("SELECT a FROM Album a").getResultList();
		List<Album> allItems = em.createQuery("SELECT a, b FROM Album a, Band b").getResultList();
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
