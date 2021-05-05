package health;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import freemarker.FreeMarkerTemplateEngine;

/**
 * <pre>
 * health 
 * HealthSpark.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 13.
 * @author : yhyeon
 * @version : v1.0
 */
public class HealthSpark {
	
	private static SessionFactory sessionFactory = HealthAnnoUtil.getSessionFactory();;
	private static Session session = sessionFactory.openSession();
	
	
	public static void main(String arg[]){
		port(30000);
		ArrayList<Object> jArr = new ArrayList<Object>();
		Map<String, Object> attributes = new HashMap<>();
		ArrayList<String> healthInfo = new ArrayList<String>();
		get("/:city/:date/:disease", (request, response) -> {
			String city = request.params(":city");
			String date = request.params(":date");
			String dis = request.params(":disease");
			List<Disease> disease = session.createQuery
					("Select c from City a, County b, Disease c, DiseaseCode d where a.code = b.city and b.countyCode = c.county and c.diseaseCode = d.diseaseCode and a.city = '" + city + "' and c.dt = '" + date + " ' and d.diseaseName = '" + dis + "'", 
							Disease.class).getResultList();
			Iterator<Disease> iterator = disease.iterator();
			while (iterator.hasNext()) {
				Disease d = iterator.next();
				healthInfo.add(new GsonBuilder().serializeNulls().create()
						.toJson(new HealthInput(d.getCounty().getCounty(), d.getPatientNum(), dis)));
			}
			
			HealthInput hl = null;
			for (int i = 0; i < healthInfo.size(); i++) {
				hl = new Gson().fromJson(healthInfo.get(i), HealthInput.class);
				jArr.add(new HealthInput(hl.getCounty(), hl.getPatientNum(), hl.getDiseaseName()));
			}
			attributes.put("message", jArr);
			return modelAndView(attributes, "health.ftl");
		}, new FreeMarkerTemplateEngine());
	}
	
}
