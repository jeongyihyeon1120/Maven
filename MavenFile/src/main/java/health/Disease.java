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
	@Column(name = "date",columnDefinition = "INT")
	private int date;
	
	@Column(name = "id",columnDefinition = "INT")
	private int id;
	
	@Column(name = "patientNum",columnDefinition = "INT")
	private int patientNum;
	
	@Column(name = "diseaseCode",columnDefinition = "INT")
	private int diseaseCode;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="CountyCode", nullable=false)
	private transient County county;

	public Disease() {
		// TODO Auto-generated constructor stub
	}
	
	public County getCounty() {
		return county;
	}
	
	public void setCounty(County county) {
		this.county = county;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientNum() {
		return patientNum;
	}

	public void setPatientNum(int patientNum) {
		this.patientNum = patientNum;
	}
	
	public int getDiseaseCode() {
		return diseaseCode;
	}
	
	public void setDiseaseCode(int diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	
	
}
