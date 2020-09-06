package spark.java;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] arg){
        get("/hello/:name", (request, response) -> {
        	String name = request.params("name");
            return name;
        });
        get("/news/:section", (request, response) -> {
            response.type("text/xml");
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
        });
    }
}