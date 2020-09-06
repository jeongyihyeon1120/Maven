package health;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import News.AnnoDoc;
import News.NewsAnnotationUtil;

public class ReadCVS {

	private static List<String[]> cityList = new ArrayList<String[]>();
	private static List<String[]> countyList = new ArrayList<String[]>();
	private static List<String[]> disease = new ArrayList<String[]>();

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

	public void citySave(String cityCode, String cityName, Set<County> countySet) {
		try {
			City city = new City();
			city.setCode(Integer.valueOf(cityCode));
			city.setCity(cityName);
//			city.setCounty(countySet);
			session.save(city);
		}catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}
	}
	public void countySave(String cityCode, String countyCode, String countyName, City city) {
		
		try {
			County county = new County();
			county.setCityCode(Integer.valueOf(cityCode));
			county.setCountyCode(Integer.valueOf(countyCode));
			county.setCounty(countyName);
			county.setCity(city);
			session.save(county);
		}catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}
	}
	public void diseaseSave(String date, String countyCode, String occur, String diseaseCode) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String ars[]) {
		ReadCVS rc = new ReadCVS();
		City city = new City();

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
		Set<County> countySet = new HashSet<County>();
		for (String[] cityArr : cityList) {
			int count = 0;
			tx = session.beginTransaction();
			for (String[] countyArr : countyList) {
				if (!countyArr[0].equals(cityArr[0])) break;
				County county = new County();
				countySet.add(county);
//				rc.countySave(countyArr[0], countyArr[1], countyArr[2], city);
				count++;
			}
			rc.citySave(cityArr[0], cityArr[1], countySet);
			tx.commit();
			for (int i = 0; i < count; i++) {
				countyList.remove(0);
			}
		}
		session.close();
	}

}
