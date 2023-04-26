package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import Utils.jdbcHelper;
import modal.Video;



public class VideoDAO {
	private static EntityManager em = jdbcHelper.getEntityManager();
	
	public static Video create(Video us) {
		System.out.println("create Video");
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

	public static Video update(Video us) {
		try {
			em.getTransaction().begin();
			em.merge(us);
			em.getTransaction().commit();
		
			return us;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	public static Video delete(String id) {
		try {
			em.getTransaction().begin();
			Video us = em.find(Video.class, id);
			em.remove(us);
			em.getTransaction().commit();
	
			return us;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}
	
	public static List<Video> findAll() {
		try {
			List<Video> list = em.createQuery("select u from Video u",Video.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Video> findAllid() {
		try {
			TypedQuery<Video> list = em.createQuery("select u.id from Video u",Video.class);
			return list.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Video findVideo(String id) {
		try {
			TypedQuery<Video> query = em.createQuery("select u from Video u where u.id = :id",Video.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Video> findKeyWord(String keyWord) {
		try {
			TypedQuery<Video> query =  em.createQuery("select u from Video u where u.title like ?0",Video.class);
			query.setParameter(0, keyWord);
			List<Video> list = query.getResultList();
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	

	public static List<Video> findPage(int page, int size) {
		try {
			TypedQuery<Video> query = em.createQuery("select u from Video u order by u.id",Video.class);
			query.setFirstResult((page-1)*size);
			query.setMaxResults(size);
			List<Video> list = query.getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static List<Video> findRecord(int start, int total) {
		try {
			TypedQuery<Video> query =em.createQuery("select u from Video u limit ?0 ,?1",Video.class);
			query.setParameter(0, (start-1)*total);
			query.setParameter(1, total);
			List<Video> list = query.getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static long getCountVideo() {
		try {
			Query list = em.createQuery("select count(u) from Video u");
			return (long) list.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static List<Video> pageRecordVideo(int index){
		int temp =(index-1)*4;
		try {
			TypedQuery<Video> query =em.createQuery("select u from Video u order by u.id offset ?0 rows fetch next 4 rows only",Video.class);
			query.setParameter(0, temp);
			List<Video> list = query.getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
}
