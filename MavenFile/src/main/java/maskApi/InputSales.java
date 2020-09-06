package maskApi;

public class InputSales {
	public String code;
	public String created_at;
	public String remain_stat;
	public String stock_at;
	
	public InputSales(String code, String created_at, String remain_stat, String stock_at) {
		this.code = code;
		this.created_at = created_at;
		this.remain_stat = remain_stat;
		this.stock_at = stock_at;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getRemain_stat() {
		return remain_stat;
	}
	public void setRemain_stat(String remain_stat) {
		this.remain_stat = remain_stat;
	}
	public String getStock_at() {
		return stock_at;
	}
	public void setStock_at(String stock_at) {
		this.stock_at = stock_at;
	}
}
