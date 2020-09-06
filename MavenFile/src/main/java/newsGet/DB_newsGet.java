package newsGet;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import freemarker.FreeMarkerTemplateEngine;

public class DB_newsGet {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/IyHyeon";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	
	static Statement stmt;
	static ResultSet res;
	static Connection conn = null;

	public static void main(String[] args) {
		port(45678);
		ArrayList<Object> jArr = new ArrayList<Object>();
		Map<String, Object> attributes = new HashMap<>();
		
		get("/news/:column/:row", (request, response) -> {
			String column = request.params("column");
			String row = request.params("row");
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			String inacQuery = "select * from NEWS where " + column + " like " + "'%" +  row + "%'";
			res = stmt.executeQuery(inacQuery);
			while (res.next()) {			
				jArr.add(new Input(res.getString("category"), res.getString("id"), res.getString("date"), res.getString("title"), res.getString("script")));
			}	
			attributes.put("message", jArr);
			return modelAndView(attributes, "news.ftl");
		}, new FreeMarkerTemplateEngine());
		
	}
}

//import static spark.Spark.get;
//import static spark.Spark.modelAndView;
//import static spark.Spark.port;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import freemarker.FreeMarkerTemplateEngine;
//
//
//public class DB_newsGet {
//	
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://dev-swh.ga:3306/IyHyeon";
//	
//	static final String USERNAME = "root";
//	static final String PASSWORD = "swhacademy!";
//	
//	static Statement stmt;
//	static ResultSet res;
//	static Connection conn = null;
//
//	public static void main(String[] args) {
//		port(45678);
//		ArrayList<Object> jArr = new ArrayList<Object>();
//		Map<String, Object> attributes = new HashMap<>();
//		
//		get("/news/:0or1/:column/:row", (request, response) -> {
//			String acc = request.params("0or1");
//			String column = request.params("column");
//			String row = request.params("row");
//			Class.forName(JDBC_DRIVER);
//			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//			stmt = conn.createStatement();
//			String acQuery = "select * from NEWS where " + column + " = " + "'" +  row + "'";
//			String inacQuery = "select * from NEWS where " + column + " like " + "'%" +  row + "%'";
//			if(acc.equals("1")) res = stmt.executeQuery(acQuery);
//			else res = stmt.executeQuery(inacQuery);
//			while (res.next()) {
//				jArr.add(new Input(res.getString("category"), res.getString("id"), res.getString("date"), res.getString("title"), res.getString("script")));
//			}
//			attributes.put("message", jArr);
//			return modelAndView(attributes, "test.ftl");
//		}, new FreeMarkerTemplateEngine());
//		
//	}
//}