package newsGet;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.LNode;
import org.bitbucket.eunjeon.seunjeon.Morpheme;

public class CompressionNews {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.0.41:3306/IyHyeon";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	
	static Statement stmt;
	static ResultSet res;
	static Connection conn = null;
	static final Charset UTF_8 = Charset.forName("UTF8");
	
	
	public List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
           public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
              return ((Comparable) v2).compareTo(v1);
            }
        });
//        Collections.reverse(list); // 주석시 오름차순
        return list;
	}

	
	public Map sort() {
		Map<String, Integer> count = new HashMap<String, Integer>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			res = stmt.executeQuery("SELECT title FROM NEWS");
			while (res.next()) {
				for (LNode node :  Analyzer.parseJava(res.getString("title"))) {
					Morpheme m = node.morpheme();
					if(m.feature().head().equals("NNG") || m.feature().head().equals("NNP")) {
						if (count.containsKey(m.surface())) count.put(m.surface(), count.get(m.surface())+ 1);
						else count.put(m.surface(), 1);
					}
				}			
			}
			res = stmt.executeQuery("SELECT script FROM NEWS");
			while (res.next()) {
				for (LNode node :  Analyzer.parseJava(res.getString("script"))) {
					Morpheme m = node.morpheme();
					if(m.feature().head().equals("NNG") || m.feature().head().equals("NNP")) {
						if (count.containsKey(m.surface())) count.put(m.surface(), count.get(m.surface())+1);
						else count.put(m.surface(), 1);
					}
				}			
			}
			Iterator it = sortByValue(count).iterator();
			Map<String, Integer> map = new LinkedHashMap<String, Integer>();
			int i = 0;
	        while(it.hasNext()) {
	        	i++;
	            String temp = (String) it.next();
	            System.out.println(temp + " = " + count.get(temp));
	            map.put(temp, count.get(temp));
	            if(i == 10) break;
	        }
	        System.out.println(1);
	        return map;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
}
