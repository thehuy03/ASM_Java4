package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.jdbcHelper;
import modal.Report;



public class ReportDAO {
	private static EntityManager em = jdbcHelper.getEntityManager();
	public static List<Report> findListReport(String id){
		try {
		TypedQuery<Report> listrp = em.createQuery("select new Report(o.user.id,count(o)) from Views o where  o.video.id = :id group by o.user.id",Report.class);
		listrp.setParameter("id", id);
		List<Report> list = listrp.getResultList();
		return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<Report> findListReportLiked(String id){
		try {
		TypedQuery<Report> listrp = em.createQuery("select new Report(o.user.id,count(o)) from Favorite o group by o.user.id",Report.class);
		listrp.setParameter("id", id);
		List<Report> list = listrp.getResultList();
		return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
