package freemarker;


import static spark.Spark.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerExample {

    public static void main(String args[]) throws IOException {

    	port(8080);
        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello FreeMarker World");

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "news.ftl");
        }, new FreeMarkerTemplateEngine());
    }
}
