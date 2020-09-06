package spark.java;
import static spark.Spark.*;
public class HtmlSpark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get("/hello", (request, response) -> {
        	return "hello";
        });
	}

}
