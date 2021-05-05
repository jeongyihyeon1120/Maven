package health;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <pre>
 * health 
 * DiseaseCode.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 7.
 * @author : yhyeon
 * @version : v1.0
 */
@Entity
@Table(name = "DiseaseCode")
public class DiseaseCode {
	
	@OneToMany(mappedBy = "diseaseCode")
	private transient Set<Disease> disease;
	
	@Column(name = "DiseaseName", columnDefinition = "char(6)")
	private String diseaseName;
	
	
	@Id
	@Column(name = "DiseaseCode", columnDefinition = "INT")
	private int diseaseCode;
	
	public int getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(int diseaseCode) {
		this.diseaseCode = diseaseCode;
	}


	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public Set<Disease> getDisease() {
		return disease;
	}
	
	public void setDisease(Set<Disease> disease) {
		this.disease = disease;
	}
	
}
