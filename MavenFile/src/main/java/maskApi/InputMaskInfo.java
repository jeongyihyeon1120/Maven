package maskApi;

public class InputMaskInfo {
	public String name;
	public String addr;
	public String remain_stat;
	
	public InputMaskInfo (String name, String addr, String remain_stat) {
		this.name = name;
		this.addr = addr;
		this.remain_stat = remain_stat;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRemain_stat() {
		return remain_stat;
	}
	public void setRemain_stat(String remain_stat) {
		this.remain_stat = remain_stat;
	}
}
