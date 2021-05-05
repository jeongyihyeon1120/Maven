package health;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ReadCVS {

	private List<String[]> cityList = new ArrayList<String[]>();
	private List<String[]> countyList = new ArrayList<String[]>();
	private List<String[]> disease = new ArrayList<String[]>();
	private List<String> diseaseName = Arrays.asList("감기", "눈병", "천식", "피부염");

	private static SessionFactory sessionFactory = HealthAnnoUtil.getSessionFactory();
	
	private static Session session = sessionFactory.openSession();
	private static Transaction tx = null;
	
	public void readCVS(String locationFilePath, String fileName) {
		String line = null;
		File locationFile = new File(locationFilePath);

		try {
			BufferedReader in = new BufferedReader(new FileReader(locationFile));
			if (fileName.contains("시도 지역코드")) {
				int count = 0;
				while ((line = in.readLine()) != null) {
					if (count == 0) {
						count = 1;
						continue; 
					} 
					String[] arr = line.split(",");
					cityList.add(arr);
				}
			} else if (fileName.contains("시군구 지역코드")) {
				int count = 0;
				while ((line = in.readLine()) != null) {
					if (count == 0) {
						count = 1;
						continue; 
					}
					String[] arr = line.split(",");
					countyList.add(arr);
				}
			} else if (fileName.contains("감기")) {
				int count = 0;
				while ((line = in.readLine()) != null) {
					if (count == 0) {
						count = 1;
						continue; 
					} 
					String[] arr = new String[4];
					for (int i = 0; i < 3; i++) {
						arr[i] = line.split(",")[i];
					}
					arr[3] = "0";
					disease.add(arr);
				}
			} else if (fileName.contains("눈병")) {
				int count = 0;
				while ((line = in.readLine()) != null) {
					if (count == 0) {
						count = 1;
						continue; 
					} 
					String[] arr = new String[4];
					for (int i = 0; i < 3; i++) {
						arr[i] = line.split(",")[i];
					}
					arr[3] = "1";
					disease.add(arr);
				}
			} else if (fileName.contains("천식")) {
				int count = 0;
				while ((line = in.readLine()) != null) {
					if (count == 0) {
						count = 1;
						continue; 
					}
					String[] arr = new String[4];
					for (int i = 0; i < 3; i++) {
						arr[i] = line.split(",")[i];
					}
					arr[3] = "2";
					disease.add(arr);
				}
			} else if (fileName.contains("피부염")) {
				int count = 0;
				while ((line = in.readLine()) != null) {
					if (count == 0) {
						count = 1;
						continue; 
					}
					String[] arr = new String[4];
					for (int i = 0; i < 3; i++) {
						arr[i] = line.split(",")[i];
					}
					arr[3] = "3";
					disease.add(arr);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public City citySave(String cityCode, String cityName) {
		tx = session.beginTransaction();
		City city = new City();
		try {
			city.setCode(Integer.valueOf(cityCode));
			city.setCity(cityName);
			session.save(city);
		}catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}
		tx.commit();
		return city;
	}
	public County countySave(String countyCode, String countyName, City city) {
		tx = session.beginTransaction();
		County county = new County();
		if (city == null) {
			return null;
		}
		try {
			county.setCountyCode(Integer.valueOf(countyCode));
			county.setCounty(countyName);
			county.setCity(city);
			session.save(county);
		}catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}
		tx.commit();
		return county;
	}
	
	
	public void diseaseSave(String date, String occur, DiseaseCode diseaseCode, County county) {
		tx = session.beginTransaction();
		Disease disease = new Disease();
		try {
			disease.setDt(date);
			disease.setPatientNum(Integer.valueOf(occur));
			disease.setDiseaseCode(diseaseCode);
			disease.setCounty(county);
			session.save(disease);
		}catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}
		tx.commit();
	}
	
	public DiseaseCode choiceCode(int code) {
		DiseaseCode dc = new DiseaseCode();
		dc.setDiseaseCode(code);
		dc.setDiseaseName(diseaseName.get(code));
		return dc;
		
	}
	
	public void diseaseCodeSave(int code) {
		tx = session.beginTransaction();
		DiseaseCode diseaseCode = new DiseaseCode();
		diseaseCode.setDiseaseCode(code);
		diseaseCode.setDiseaseName(diseaseName.get(code));
		session.save(diseaseCode);
		tx.commit();
	}

	
	public static void main(String ars[]) {
		ReadCVS rc = new ReadCVS();
		String locationFilePath = "C:\\Users\\yhyeon\\Downloads\\국민건강보험공단 실제진료정보(20191219)\\";

		File dir = new File(locationFilePath);
		File[] fileList = dir.listFiles();

		for (File file : fileList) {
			if (file.isFile()) {
				String fileName = file.getName();
				System.out.println(fileName);
				rc.readCVS(locationFilePath + fileName, fileName);
			}
		}
		
		for (int i = 0; i < rc.diseaseName.size(); i++) {
			rc.diseaseCodeSave(i);
		}
		
		for (String[] cityArr : rc.cityList) {
			int count = 0;
//			tx = session.beginTransaction();
			City city = rc.citySave(cityArr[0], cityArr[1]);
			for (String[] countyArr : rc.countyList) {
				if (!countyArr[0].equals(cityArr[0])) continue;
				County county = rc.countySave(countyArr[1], countyArr[2], city);
				count++;
				int c = 0;
				for (String[] disArr : rc.disease) {
					if (c == 100) {
						break;
					}
					c++;
					if(!disArr[1].equals(countyArr[1])) {
						c--;
						continue;
					}
					rc.diseaseSave(disArr[0], disArr[2], rc.choiceCode(Integer.valueOf(disArr[3])), county);
				}
				for (int i = 0; i < rc.disease.size(); i++) {
					
				}
			}
//			tx.commit();
			for (int i = 0; i < count; i++) {
				rc.countyList.remove(0);
			}
			
		}
		session.close();
	}

}
