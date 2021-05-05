package health;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * <pre>
 * health 
 * SavaCVS.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 20.
 * @author : yhyeon
 * @version : v1.0
 */
public class SavaCVS {

	String locationFilePath = "C:\\Users\\yhyeon\\Downloads\\국민건강보험공단 실제진료정보(20191219)\\";
	ArrayList<String> fileName = new ArrayList<String>();

	public SavaCVS() {

		File dir = new File(locationFilePath);
		File[] fileList = dir.listFiles();

		for (File file : fileList) {
			if (file.isFile()) {
				fileName.add(file.getName());
				System.out.println(file.getName());
			}
		}

	}

	public ArrayList<String[]> ReadCity() {
		String line = null;
		File locationFile = new File(locationFilePath + fileName.get(1));
		ArrayList<String[]> cityList = new ArrayList<String[]>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(locationFile));
			int count = 0;
			while ((line = in.readLine()) != null) {
				if (count == 0) {
					count = 1;
					continue;
				}
				String[] arr = line.split(",");
				cityList.add(arr);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cityList;

	}

	public ArrayList<String[]> ReadCounty() {
		String line = null;
		File locationFile = new File(locationFilePath + fileName.get(0));
		ArrayList<String[]> countyList = new ArrayList<String[]>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(locationFile));
			int count = 0;
			while ((line = in.readLine()) != null) {
				if (count == 0) {
					count = 1;
					continue;
				}
				String[] arr = line.split(",");
				countyList.add(arr);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return countyList;
	}

	public ArrayList<String[]> ReadDisease() {
		ArrayList<String[]> diseaseList = new ArrayList<String[]>();
		try {
			for (int i = 2; i < fileName.size(); i++) {
				String line = null;
				File locationFile = new File(locationFilePath + fileName.get(i));
				BufferedReader in = new BufferedReader(new FileReader(locationFile));
				int count = 0;
					while ((line = in.readLine()) != null) {
						if (count == 0) {
							count = 1;
							continue; 
						} 
						String[] arr = new String[4];
						for (int j = 0; j < 3; j++) {
							arr[j] = line.split(",")[j];
						}
						arr[3] = Integer.toString(i - 2);
						diseaseList.add(arr);
					}
				}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return diseaseList;
	}
	
	
}
