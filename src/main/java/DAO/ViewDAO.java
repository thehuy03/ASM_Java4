package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.jdbcHelper;
import modal.Views;


public class ViewDAO {
	private static EntityManager em = jdbcHelper.getEntityManager();
	
	public static Views create(Views v) {
		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
			return v;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Views> findViewByIdVideo(String idVideo){
		try {
			TypedQuery<Views> list = em.createQuery("select u from Views u where u.video.id = :id",Views.class);
			list.setParameter("id", idVideo);
			return list.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Views> findAll(){
		try {
			List<Views> list = em.createQuery("select u from Views u",Views.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
