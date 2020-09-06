package maskApi;

public class InputStore {
	public String addr;
	public String code;
	public String lat;
	public String lng;
	public String name;
	public String type;
	public String getAddr() {
		return addr;
	}
	
	public InputStore(String type, String name, String addr, String code, String lat, String lng) {
		this.type = type;
		this.name = name;
		this.addr = addr;
		this.code = code;
		this.lat = lat;
		this.lng = lng;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
