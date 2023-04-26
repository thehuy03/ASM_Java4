package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.jdbcHelper;

import modal.Users;
import modal.Views;

public class UserDAO {
	
	
	
	public Users create(Users us) {	
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(us);
			em.getTransaction().commit();
			return us;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	public static Users update(Users us) {
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(us);
			System.out.println("DAO update");
			em.getTransaction().commit();
			return us;
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
			return null;
		}
	}

	public static  Users delete(String id) {
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			Users us = em.find(Users.class, id);
			em.remove(us);
			em.getTransaction().commit();
	
			return us;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	public static List<Users> findAll() {
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			List<Users> list = em.createQuery("select u from Users u",Users.class).getResultList();
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static Users findUser(String id, String password) {
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			TypedQuery<Users> query = em.createQuery("select u from Users u where u.id= :id and u.password= :pw",Users.class);
			query.setParameter("id", id);
			query.setParameter("pw", password);
			Users us =  query.getSingleResult();
			return us;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
	
	public static Users findUser(String id) {
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			TypedQuery<Users> query = em.createQuery("select u from Users u where u.id= :id ",Users.class);
			query.setParameter("id", id);
			Users us =  query.getSingleResult();
			System.out.println("findDAOUS");
			return us;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
	
	public static Users updatePass(String id,String newpass) {
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			TypedQuery<Users> query = em.createQuery("update Users u set u.password = :newpass where u.id= :id ",Users.class);
			query.setParameter("newpass", newpass);
			query.setParameter("id", id);
			Users us =  query.getSingleResult();
			return us;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
	
	public static List<Views> findUserWatchVideo(String title){
		EntityManager em = jdbcHelper.getEntityManager();
		try {
			TypedQuery<Views> list = em.createNamedQuery("Users.findUserWatchVideo", Views.class);
			list.setParameter("id", title);
			return list.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
