package health;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.GsonBuilder;

/**
 * <pre>
 * health 
 * Test.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 20.
 * @author : yhyeon
 * @version : v1.0
 */
public class Test {

	private static SessionFactory sessionFactory = HealthAnnoUtil.getSessionFactory();;
	private static Session session = sessionFactory.openSession();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> healthInfo = new ArrayList<String>();
		List<Disease> disease = session.createQuery
				("Select c from City a, County b, Disease c, DiseaseCode d where a.code = b.city and b.countyCode = c.county and c.diseaseCode = d.diseaseCode and a.city = '서울' and c.dt = '20140101' and d.diseaseName = '감기'",
//						+ " and d.diseaseName = '감기'", 
						Disease.class).getResultList();
		Iterator<Disease> iterator = disease.iterator();
		while (iterator.hasNext()) {
			Disease d = iterator.next();
			System.out.println();
//			healthInfo.add(new GsonBuilder().serializeNulls().create()
//					.toJson(new HealthInput(d.getCounty().getCounty(), d.getPatientNum(), "감기")));
		}
	
	}

}
