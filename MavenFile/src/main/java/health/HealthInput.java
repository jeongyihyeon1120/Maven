package health; 

/**
 * <pre>
 * health 
 * HealthInput.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 20.
 * @author : yhyeon
 * @version : v1.0
 */
public class HealthInput {
	
	private String county;
	private int patientNum;
	private String diseaseName;
	
	public HealthInput(String county, int patientNum, String diseaseName) {
		// TODO Auto-generated constructor stub
		this.county = county;
		this.patientNum = patientNum;
		this.diseaseName = diseaseName;
	}
	
	public HealthInput() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public int getPatientNum() {
		return patientNum;
	}
	public void setPatientNum(int patientNum) {
		this.patientNum = patientNum;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	
	
}
