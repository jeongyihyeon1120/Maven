package News;

import static spark.Spark.post;

import com.google.gson.Gson;

import static spark.Spark.port;

public class NewsPostServer {
	static Input i = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		port(8080);
		post("/hello", (request, response) -> {
			try {
				System.out.println(request.body());
				Anno_query anno = new Anno_query();
				i = new Gson().fromJson(request.body(),Input.class);
				anno.infoSave(i.category,i.id, i.title, i.script, i.date);
				
				return "정상처리 되었습니다.";		
			}catch (Exception e) {
				return "오류가 발생했습니다.";
			}
		});
	}
}

