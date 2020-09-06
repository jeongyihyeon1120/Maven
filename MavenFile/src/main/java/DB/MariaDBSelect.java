package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MariaDBSelect {
	User u = new User();
	ArrayList<User> u_List = new ArrayList<User>();

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/IyHyeon";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	public void Making() {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("MariaDB 연결.");
			statement = connection.createStatement();

			// insert
			boolean result = statement.execute(
					"insert into employees(name,hourly_pay,position,employee_contact) values('쿠굘',8.00,'Helper',5152330065);");
//			boolean result = statement.execute(String.format("insert into a(c1,c2) values(%d, %s);", v1, v2));
			if (result)
				System.out.println("정상처리");
			else
				System.out.println("비정상처리");

			// update
//			int result = statement.executeUpdate("update a set c1 = v1;");		//	result = 업데이터된 행의 숫자
//			if(result > 0) System.out.println("정상처리");
//			else System.out.println("비정상처리");

			// select
			ResultSet rs = statement.executeQuery("SELECT * FROM employees;");

			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String name = rs.getString("name");
				double hourly_pay = rs.getDouble("hourly_pay");
				long employee_contact = rs.getLong("employee_contact");
				u.Set_Name(rs.getString(name));
				u.Set_Employee_id(employee_id);
				u.Set_Hourly_pay(hourly_pay);
				u.Set_Employee_contact(employee_contact);
				u_List.add(u);
//				System.out.println("employee_id : " + employee_id);
//				System.out.println("name: " + name);
//				System.out.println("hourly_pay: " + hourly_pay);
//				System.out.println("employee_contact: " + employee_contact);
			}
			rs.close();
		} catch (SQLException se1) {
			se1.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se2) {
			}
		}
		System.out.println("MariaDB 연결종료.");
	}

	public static void main(String[] args) {
		MariaDBSelect m = new MariaDBSelect();
		m.Making();
		System.out.println(m.u_List);
	}
}