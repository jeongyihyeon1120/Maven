package Naver;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Input> newsinfo = new ArrayList<Input>();
		Document doc = Jsoup.connect("https://news.naver.com/main/list.nhn?mode=LS2D&mid=sec&sid1=100&sid2=269").get();
		Element news = doc.select("ul.list_txt").get(0);
		System.out.println(news);
		Elements result = news.select("li");
		System.out.println(result);
		String n = "";
		String s = "";
		String d = "";
		for (Element element : result) {
			n = element.text();
			String html = element.getElementsByAttribute("href").attr("href");
			Document inside = Jsoup.connect(html).get();
			Elements scripts = inside.select("#articleBodyContents");
			for (Element e : scripts) {
				s = e.text();
			}
			Elements date = inside.select("span.t11");
			for (Element e : date) {
				d = e.text();
			}
			newsinfo.add(new Input(n, s, d));
		}
		for (int i = 0; i < newsinfo.size(); i++) {
			String jon = new GsonBuilder().serializeNulls().create().toJson(newsinfo.get(i));
			System.out.println(jon);
		}
		System.out.println("");
	}
}
