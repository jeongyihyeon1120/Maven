package News;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Anno_query {
	private static SessionFactory sessionFactory = NewsAnnotationUtil.getSessionFactory();
	
	public String infoSave(String category,String id, String title, String script, String date) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
//		Integer personID = null;
		try {
			tx = session.beginTransaction();
			AnnoDoc ad = new AnnoDoc(category ,id, title, script, date);
			session.save(ad);
			tx.commit();
		}catch (Exception e) {
			if (tx!=null) tx.rollback();
//			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return id;
		
	}
	
}
