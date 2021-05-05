package health;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * <pre>
 * health 
 * HealthAnnoUtil.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 6.
 * @author : yhyeon
 * @version : v1.0
 */
public class HealthAnnoUtil {
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	
	static{
		try{
			Configuration configuration = new Configuration().configure("hibernate-annotation-health.cfg.xml");
			
			configuration.addAnnotatedClass(City.class);
			configuration.addAnnotatedClass(County.class);
			configuration.addAnnotatedClass(Disease.class);
			configuration.addAnnotatedClass(DiseaseCode.class);
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){ 
		return sessionFactory;
	}
}
