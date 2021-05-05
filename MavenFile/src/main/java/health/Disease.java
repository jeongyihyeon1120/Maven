package health;

import javax.persistence.*;

/**
 * <pre>
 * health 
 * Disease.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 8. 30.
 * @author : yhyeon
 * @version : v1.0
 */
@Entity
@Table(name = "Disease")
public class Disease {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk")
	private int pk;
	
	@Column(name = "dt",columnDefinition = "CHAR(8)")
	private String dt;
	
	@Column(name = "patientNum",columnDefinition = "INT")
	private int patientNum;
	
	@ManyToOne
	@JoinColumn(name = "diseaseCode",nullable=false)
	private DiseaseCode diseaseCode;

	@ManyToOne
	@JoinColumn(name="CountyCode", nullable=false)
	private County county;

	public Disease() {
		// TODO Auto-generated constructor stub
	}
	
	public County getCounty() {
		return county;
	}
	
	public void setCounty(County county) {
		this.county = county;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public int getPatientNum() {
		return patientNum;
	}

	public void setPatientNum(int patientNum) {
		this.patientNum = patientNum;
	}
	
	public DiseaseCode getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(DiseaseCode diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public int getPk() {
		return pk;
	}
	
	public void setPrimary(int pk) {
		this.pk = pk;
	}
	
}
