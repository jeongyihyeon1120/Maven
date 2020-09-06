package health; 

import java.util.Set;

import javax.persistence.*;
/**
 * <pre>
 * health 
 * City.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 8. 30.
 * @author : yhyeon
 * @version : v1.0
 */

@Entity
@Table(name = "City")
public class City {
	@Id
	@Column(name = "code",columnDefinition = "INT")
	private int code;
	
	@Column(name = "city",columnDefinition = "char(4)")
	private String city;
	
//	@OneToMany
//	private transient Set<County> county;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

//	public Set<County> getCounty() {
//		return county;
//	}
//
//	public void setCounty(Set<County> county) {
//		this.county = county;
//	}
	
}
