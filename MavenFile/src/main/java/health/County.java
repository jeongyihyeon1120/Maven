package health;

import java.util.Set;

import javax.persistence.*;

/**
 * <pre>
 * health 
 * county.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 8. 30.
 * @author : yhyeon
 * @version : v1.0
 */
@Entity
@Table(name = "County")
public class County {
	
	@Id
	@Column(name = "countyCode",columnDefinition = "INT")
	private int countyCode;
	
	@Column(name = "county",columnDefinition = "varchar(20)")
	private String county;
	
	@ManyToOne
	@JoinColumn(name="cityCode", nullable=false)
	private City city;
	
	@OneToMany(mappedBy = "county")
	private transient Set<Disease> diseases;

	public Set<Disease> getDiseases() {
		return diseases;
	}


	public void setDiseases(Set<Disease> diseases) {
		this.diseases = diseases;
	}


	public County() {
		// TODO Auto-generated constructor stub
	}

	public int getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(int countyCode) {
		this.countyCode = countyCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
}
