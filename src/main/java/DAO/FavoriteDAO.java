package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.jdbcHelper;
import modal.Favorite;


public class FavoriteDAO {
	private static EntityManager em = jdbcHelper.getEntityManager();
	
	public static Favorite create(Favorite us) {
		System.out.println("create Favorite");
		try {
			em.getTransaction().begin();
			em.persist(us);
			em.getTransaction().commit();
			return us;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Favorite> findAll(){
		try {
			List<Favorite> listF = em.createQuery("select f from Favorite f",Favorite.class).getResultList();
			return listF;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Favorite> findByIVideo(String id){
		try {
			TypedQuery<Favorite> listF = em.createQuery("select f from Favorite f where f.video.id = :id",Favorite.class);
			listF.setParameter("id", id);
			return listF.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
