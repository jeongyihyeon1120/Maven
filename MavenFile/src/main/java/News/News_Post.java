package News;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.select.Elements;

import com.google.gson.GsonBuilder;


public class News_Post {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		HttpClient client = HttpClients.createDefault();
		HttpPost request = new HttpPost("http://localhost:8080/hello");
		Articles a = new Articles();
		Date d = new Date();
		ArrayList<String> day = d.date("20200202", "20200202");
		System.out.print("1. 정치, 2. 경제, 3. 사회, 4. 문화, 5. 세계, 6. 과학, 7. IT, 8. 스포츠, 9. 연예, 10. 기후");
		Scanner s = new Scanner(System.in);
		int select = s.nextInt();
		int sid1 = 0;
		int sid2 = 0;
		String category = "";
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> scripts = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> dates = new ArrayList<String>();
		Elements e;
		if (select == 1) {
			sid1 = 100;
			sid2 = 269;
			category = "정치";
		} else if (select == 2) {
			sid1 = 101;
			sid2 = 263;
			category = "경제";
		} else if (select == 3) {
			sid1 = 102;
			sid2 = 257;
			category = "사회";
		} else if (select == 4) {
			sid1 = 103;
			sid2 = 245;
			category = "문화";
		} else if (select == 5) {
			sid1 = 104;
			sid2 = 322;
			category = "세계";
		} else if (select == 6) {
			sid1 = 105;
			sid2 = 228;
			category = "과학";
		} else if (select == 7) {
			sid1 = 105;
			sid2 = 230;
			category = "IT";
		} else if (select == 8) {
			sid1 = 100;
			sid2 = 269;
			category = "스포츠";
		} else if (select == 9) {
			sid1 = 100;
			sid2 = 269;
			category = "연예";
		} else if (select == 10) {
			sid1 = 100;
			sid2 = 269;
			category = "기후";
		}
		s.close();
		for (int i = 0; i < day.size(); i++) {
			int page = 0;
			titles.clear();
			scripts.clear();
			id.clear();
			dates.clear();
			System.out.println(day.get(i));
			while (true) {
				page += 1;
				e = a.getBasic(sid1, sid2, day.get(i), page);
				titles = a.getTitle(e);
				scripts = a.getScript(e);
				if (titles.isEmpty()) {
					System.out.println("end");
					break;
				}
				id = a.id;
				dates = a.dates;
				System.out.println(page);
				for (int j = 0; j < titles.size(); j++) {
			        try {
			        	String json = new GsonBuilder().serializeNulls().create()
			        			.toJson(new Input(titles.get(j), scripts.get(j), id.get(j), dates.get(i), category));
			            //  추가할 데이터
			            HttpEntity entity = new StringEntity(json, "UTF-8");
			            request.setEntity(entity);
			            
			            //  전송
			            HttpResponse response = client.execute(request);
			            
			            //  응답
			            String result = EntityUtils.toString(response.getEntity());
			            System.out.println(result);
			        } catch (IOException e2) {
			            // TODO Auto-generated catch block
			            e2.printStackTrace();
			        }
				}
			}
			id.clear();
			dates.clear();
		}
	}
}
