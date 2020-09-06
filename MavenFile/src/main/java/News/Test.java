package News;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String title = "";
//		Elements script;
//		String date = "";
//		ArrayList<String> a = new ArrayList<String>();
//		ArrayList<String> b = new ArrayList<String>();
//		ArrayList<String> c1 = new ArrayList<String>();
//		int j = 0;
//		
//		String url = "https://news.naver.com/main/list.nhn?sid1=100&sid2=269&mid=shm&mode=LS2D&date=20191116&page=1";
//		Document doc = Jsoup.connect(url).get();
//		Element news = doc.select("div.list_body").get(0);
//		Elements result = news.select("dt");
//		for (Element element : result) {
//			j ++;
////			if (j % 2 != 0) {
////				continue;
////			}
//			Elements abc = element.select("dt.photo");
//			String ab = abc.toString();
////			System.out.println(ab);
//			if (ab.equals(""));
//			else continue;
////			System.out.println(abc+ "//");
//			title = element.text();
//			System.out.println(title);
//			a.add(title);	
//			url = element.getElementsByAttribute("href").attr("href");
//			System.out.println(url);
//			String c = url.split("&")[5].split("=")[1];
//			c1.add(c);
//			if (c1.contains(c)) {
//				System.out.println("noob!");
//			}
//			Document in = Jsoup.connect(url).get();
//			script = in.select("#articleBodyContents");
////			System.out.println(script);
//			Elements dates = in.select("span.t11");
//			for (int i = 0; i < script.size(); i++) {
//				Element e = script.get(i);
//				String s = e.text();
//				System.out.println(s);
//				b.add(s);
//			}
//				Element e = dates.get(0);
//				String s = e.text();
//				System.out.println(s);
//				System.out.println(s.split(" ")[0]);
//				System.out.println(s.split(" ")[1]);
//				System.out.println(s.split(" ")[2]);
//				String ba = s.split(" ")[0];
//				String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
//				ba = ba.replaceAll(match, " ");
//				System.out.println(ba);
//			}
//		}
////		for (int i = 0; i < a.size(); i++) {
////			System.out.println("-----------------------------제목-----------------------");
////			System.out.println(a.get(i));
////			System.out.println("-----------------------------본문-----------------------");
////			System.out.println(b.get(i));
////		}
//	}
//
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		System.out.println(a);
	}
}

