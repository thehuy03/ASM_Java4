package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jdbcHelper {
	private static EntityManagerFactory emf =null;

//	EntityManager em = emf.createEntityManager(); 

	static public EntityManager getEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("HDTTube");
		}
		return emf.createEntityManager();
	}
	
	static public void shutDown() {
		if(emf!=null||emf.isOpen()) {
			emf.close();
		}
		emf=null;
	}
	
}
