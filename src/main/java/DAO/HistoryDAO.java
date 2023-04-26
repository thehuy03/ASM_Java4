package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.jdbcHelper;
import modal.History;
import modal.Users;
import modal.Video;

public class HistoryDAO {
	private static EntityManager em = jdbcHelper.getEntityManager();
	
	public static History create(History h) {
		try {
			em.getTransaction().begin();
			em.persist(h);
			em.getTransaction().commit();
			return h;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public static History update(History h) {
//		try {
//			em.getTransaction().begin();
//			em.merge(h);
//			em.getTransaction().commit();
//		
//			return h;
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public static History delete(String id) {
//		try {
//			em.getTransaction().begin();
//			History h = em.find(History.class, id);
//			em.remove(h);
//			em.getTransaction().commit();
//	
//			return h;
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			return null;
//		}
//	}
	
	public static List<History> findAll(){
		try {
			List<History> list = em.createQuery("select u from History u",History.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<History> findAllByIdUser(String id){
		try {
			TypedQuery<History> query = em.createQuery("select u from History u where u.user.id = :id",History.class);
			query.setParameter("id", id);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
