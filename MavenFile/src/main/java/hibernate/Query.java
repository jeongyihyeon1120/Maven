package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * <pre>
 * kr.co.swh.lecture.database.java.hibernate.hbm 
 * Query.java
 *
 * 설명 : 하이버네이트 쿼리 테스트
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class Query {
	public static void main( String[] args ){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        SWHAcademy12 user = new SWHAcademy12();
        user.setEmail("swhacademy@gmail.com");
        user.setName("SWH");
        user.setId("key1");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("Insert completed");

//        session.beginTransaction();
//        SWHAcademy myuser = (SWHAcademy)session.get(SWHAcademy.class, "key");
//        System.out.println("name:"+myuser.getName());
//        myuser.setName("SWHAcademy");
//        session.getTransaction().commit();
        
        session.close();
        sessionFactory.close();
    }
}