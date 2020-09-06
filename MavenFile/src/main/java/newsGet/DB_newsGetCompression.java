package newsGet;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import freemarker.FreeMarkerTemplateEngine;

public class DB_newsGetCompression {
	
	public static void main(String[] args) {
		ArrayList<WordCloud> wc = new ArrayList<WordCloud>();
		ArrayList<String> wc1 = new ArrayList<String>();
		CompressionNews cn = new CompressionNews();
		Map<String, Integer> compression = cn.sort();
		port(8080);
        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            for(String key : compression.keySet()){
            	int value = compression.get(key);
            	value = (int)value / 100;
            	wc.add(new WordCloud(key, value));
            }
            attributes.put("message",wc);
            return modelAndView(attributes, "test.ftl");
        }, new FreeMarkerTemplateEngine());
	}
}
