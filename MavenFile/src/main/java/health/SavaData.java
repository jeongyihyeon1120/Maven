package health;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * <pre>
 * health 
 * SavaData.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 20.
 * @author : yhyeon
 * @version : v1.0
 */
public class SavaData {

	private SessionFactory sessionFactory = HealthAnnoUtil.getSessionFactory();

	private Session session = sessionFactory.openSession();
	private Transaction tx = null;
	
	private ArrayList<ArrayList<String>> cityArrayList = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> countyArrayList = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> codeArrayList = new ArrayList<ArrayList<String>>();
	
	public void citySave(ArrayList<String[]> cityList) {
		tx = session.beginTransaction();
		for (String[] cityArr : cityList) {
			City city = new City();
			ArrayList<String> arr = new ArrayList<String>();
			try {
				city.setCode(Integer.valueOf(cityArr[0]));
				city.setCity(cityArr[1]);
				arr.add(cityArr[0]);
				arr.add(cityArr[1]);
				cityArrayList.add(arr);
				session.save(city);
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		tx.commit();
	}

	public void countySave(ArrayList<String[]> countyList) {
		tx = session.beginTransaction();
		for (String[] countyArr : countyList) {
			County county = new County();
			ArrayList<String> arr = new ArrayList<String>();
			try {
				arr.add(countyArr[0]);
				arr.add(countyArr[1]);
				arr.add(countyArr[2]);
				countyArrayList.add(arr);
				if(giveCity(countyArr[0]).equals(null)) continue;
				county.setCountyCode(Integer.valueOf(countyArr[1]));
				county.setCounty(countyArr[2]);
				county.setCity(giveCity(countyArr[0]));
				session.save(county);
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		tx.commit();
	}

	public void diseaseSave(ArrayList<String[]> diseaseArr) {
		tx = session.beginTransaction();
		for (String[] disArr : diseaseArr) {
			Disease disease = new Disease();
			if(giveCounty(disArr[1]).equals(null)) continue;
			try {
				disease.setCounty(giveCounty(disArr[1]));
				disease.setDt(disArr[0]);
				disease.setPatientNum(Integer.valueOf(disArr[2]));
				disease.setDiseaseCode(giveCode(disArr[3]));
				session.save(disease);
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		tx.commit();
	}

	public void diseaseCode(List<String> diseaseName) {
		tx = session.beginTransaction();
		for (int i = 0; i < diseaseName.size(); i++) {
			DiseaseCode code = new DiseaseCode();
			ArrayList<String> arr = new ArrayList<String>();
			try {
				arr.add(Integer.toString(i));
				arr.add(diseaseName.get(i));
				codeArrayList.add(arr);
				code.setDiseaseCode(i);
				code.setDiseaseName(diseaseName.get(i));
				session.save(code);
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		tx.commit();
	}

	public City giveCity(String cityCode) {
		City city = new City();
		for (int i = 0; i < cityArrayList.size(); i++) {
			ArrayList<String> arr = new ArrayList<String>();
			arr = cityArrayList.get(i);
			for (int j = 0; j < arr.size(); j++) {
				if(cityCode.equals(arr.get(0))) {
					city.setCode(Integer.valueOf(arr.get(0)));
					city.setCity(arr.get(1));
					return city;
				}
			}
		}
		return null;
	}
	
	public County giveCounty(String countyCode) {
		County county = new County();
		for (int i = 0; i < countyArrayList.size(); i++) {
			ArrayList<String> arr = new ArrayList<String>();
			arr = countyArrayList.get(i);
			for (int j = 0; j < arr.size(); j++) {
				if(countyCode.equals(arr.get(1))) {
					county.setCountyCode(Integer.valueOf(arr.get(1)));
					county.setCounty(arr.get(2));
					county.setCity(giveCity(arr.get(0)));
					return county;
				}
			}
		}
		return null;
	}

	public DiseaseCode giveCode(String code) {
		DiseaseCode diseaseCode = new DiseaseCode();
		for (int i = 0; i < codeArrayList.size(); i++) {
			ArrayList<String> arr = new ArrayList<String>();
			arr = codeArrayList.get(i);
			for (int j = 0; j < arr.size(); j++) {
				if(code.equals(arr.get(0))) {
					diseaseCode.setDiseaseCode(Integer.valueOf(arr.get(0)));
					diseaseCode.setDiseaseName(arr.get(1));
					return diseaseCode;
				}
			}
		}
		return null;
	}

}
