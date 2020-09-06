package DB;

public class User {
	
	private String name;
	private int employee_id;
	private double hourly_pay;
	private long employee_contact;
	
	public String Get_Name() {
		return name;
	}
	public void Set_Name(String name) {
		this.name = name;
	}
// -----------------------------------------------	
	public int Get_Employee_id() {
		return employee_id;
	}
	public void Set_Employee_id(int employee_id) {
		this.employee_id = employee_id;
	}
// -----------------------------------------------	
	public double Get_Hourly_pay() {
		return hourly_pay;
	}
	public void Set_Hourly_pay(double hourly_pay) {
		this.hourly_pay = hourly_pay;
	}
// -----------------------------------------------	
	public long Get_Employee_contact() {
		return employee_contact;
	}
	public void Set_Employee_contact(long employee_contact) {
		this.employee_contact = employee_contact;
	}
	
}
