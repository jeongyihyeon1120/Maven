package News;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.select.Elements;

import com.google.gson.GsonBuilder;

public class NewsNetworking {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Articles a = new Articles();
		ArrayList<Input> infor_news = new ArrayList<Input>();
		Date d = new Date();
		ArrayList<String> day = d.date("20200801", "20200801");
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
					infor_news.add(new Input(titles.get(j), scripts.get(j), id.get(j), dates.get(i), category));
					Socket sock = null;
					PrintWriter pw = null;
					InetAddress ia = null;
					try {
						ia = InetAddress.getByName("127.0.0.1");
						sock = new Socket(ia, 10001);
						pw = new PrintWriter(sock.getOutputStream());
						String json = new GsonBuilder().serializeNulls().create()
								.toJson(new Input(titles.get(j), scripts.get(j), id.get(j), dates.get(i), category));
						pw.println(json);
//						Thread.sleep(10);
						pw.flush();
						sock.close();
					} catch (Exception e1) {
						System.out.println(e1);
					} finally {
						if (pw != null) {
							pw.close();
						}
					}
				}
				id.clear();
				dates.clear();
			}
		}
	}
}
