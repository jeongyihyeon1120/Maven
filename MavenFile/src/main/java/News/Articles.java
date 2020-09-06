	package News;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scala.reflect.internal.Trees.If;

public class Articles {
	boolean bool = false;
	int checking = 0;
	int checking2 = 0;
	String title;
	String date;
	Elements script;
	Elements check1;
	String check2;
	String id1;
	String id2;
	String id3;
	String id4;
	String id5;
	ArrayList<String> id = new ArrayList<String>();
	ArrayList<String> scripts = new ArrayList<String>();
	ArrayList<String> titles = new ArrayList<String>();
	ArrayList<Element> check = new ArrayList<Element>();
	ArrayList<String> dates = new ArrayList<String>();
	ArrayList<String> empty = new ArrayList<String>();

	public Elements getBasic(int sid1, int sid2, String date, int page) throws IOException {
		String url = "https://news.naver.com/main/list.nhn?mode=LS2D&sid2=" + sid2 + "&sid1=" + sid1 + "&mid=shm&date="
				+ date + "&page=" + page;
		Document doc = Jsoup.connect(url).get();
		Element news = doc.select("div.list_body").get(0);
		Elements result = news.select("dt");
		return result;
	}

	public ArrayList<String> getTitle(Elements dt) throws InterruptedException {
		int checkTitle = 0;
		if (checking >= 1) {
			titles.clear();
		}
		for (Element e : dt) {
			check1 = e.select("dt.photo");
			check2 = check1.toString();
			if (check.contains(e)) return empty;
			if (check2.equals(""));
			else continue;
			checkTitle ++;
			title = e.text();
			titles.add(title);
			check.add(e);
			if (checkTitle != titles.size()) titles.add(null);
		}
		checking += 1;
		return titles;
	}

	public ArrayList<String> getScript(Elements dt) throws IOException, InterruptedException {
		if (checking2 >= 1) {
			scripts.clear();
		}
		int counting123 = 0;
		for (Element e : dt) {
			String url;
			check1 = e.select("dt.photo");
			check2 = check1.toString();
			if (check2.equals(""))
				;
			else
				continue;
			url = e.getElementsByAttribute("href").attr("href");
			id1 = url.split("&")[2].split("=")[1];
			id2 = url.split("&")[3].split("=")[1];
			id3 = url.split("&")[4].split("=")[1];
			id4 = url.split("&")[5].split("=")[1];
			id5 = id1 + id2 + id3 + id4;
			bool = stop(id5);
			id.add(id5);
			Document in = Jsoup.connect(url).get();
			Elements d = in.select("span.t11");
			String s0 = d.text();
			String s1 = s0.split(" ")[0];
			String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
			s1 = s1.replaceAll(match, " ");
			dates.add(s1);
			script = in.select("#articleBodyContents");
			counting123 ++;
			for (Element element : script) {
				String s = element.text();
				scripts.add(s);
			}
			if (counting123 != scripts.size()) scripts.add(null);
		}
		checking2 += 1;
		return scripts;
	}
	public boolean stop(String id) {
		if(this.id.contains(id)) {
			return true;
		}
		else {
			return false;
		}
	}

}
