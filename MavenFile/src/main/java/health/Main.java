package health;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * health 
 * Main.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 20.
 * @author : yhyeon
 * @version : v1.0
 */
public class Main {

	public static void main(String[] args) {
		SavaCVS sc = new SavaCVS();
		SavaData sd = new SavaData();
		
		ArrayList<String[]> cityList = new ArrayList<String[]>();
		ArrayList<String[]> countyList = new ArrayList<String[]>();
		ArrayList<String[]> disease = new ArrayList<String[]>();
		List<String> diseaseName = Arrays.asList("감기", "눈병", "천식", "피부염");
		
		cityList = sc.ReadCity();
		countyList = sc.ReadCounty();
		disease = sc.ReadDisease();
		
		sd.citySave(cityList);
		sd.countySave(countyList);
		sd.diseaseCode(diseaseName);
		sd.diseaseSave(disease);
		
		
	}

}
