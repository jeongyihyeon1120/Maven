package maskApi;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.GsonBuilder;

public class Test2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<String> salesInfos = new ArrayList<String>();
		ArrayList<String> storeInfos = new ArrayList<String>();
		ArrayList<String> maskInfos = new ArrayList<String>();
		int page = 0;
		while (true) {
			page++;
			Document docSales = Jsoup
					.connect("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/sales/json?page=" + page)
					.ignoreContentType(true).get();
			Document docStore = Jsoup
					.connect("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + page)
					.ignoreContentType(true).get();
			String salesBody = docSales.getElementsByTag("body").text();
			String storeBody = docStore.getElementsByTag("body").text();
			try {
				System.out.println(page);
				JSONParser parser = new JSONParser();
				Object objSales = parser.parse(salesBody);
				Object objStore = parser.parse(storeBody);
				JSONObject jsonObjSales = (JSONObject) objSales;
				JSONObject jsonObjStore = (JSONObject) objStore;
				JSONArray salesInfoArray = (JSONArray) jsonObjSales.get("sales");
				JSONArray storeInfoArray = (JSONArray) jsonObjStore.get("storeInfos");
				if (storeInfoArray.size() == 0)
					break;
				for (int i = 0; i < salesInfoArray.size(); i++) {
					JSONObject salesObject = (JSONObject) salesInfoArray.get(i);
					salesInfos.add(salesObject.get("code").toString());
					salesInfos.add((String) salesObject.get("remain_stat"));
				}
				for (int i = 0; i < storeInfoArray.size(); i++) {
					JSONObject storeObject = (JSONObject) storeInfoArray.get(i);
					storeInfos.add(storeObject.get("code").toString());
					storeInfos.add((String) storeObject.get("name"));
					storeInfos.add((String) storeObject.get("addr"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < salesInfos.size(); i += 2) {
			System.out.println(storeInfos.get(storeInfos.indexOf(salesInfos.get(i)) + 1));
			System.out.println(storeInfos.get(storeInfos.indexOf(salesInfos.get(i)) + 2));
			System.out.println(salesInfos.get(i + 1));
			maskInfos.add(new GsonBuilder().serializeNulls().create()
					.toJson(new InputMaskShow(storeInfos.get(storeInfos.indexOf(salesInfos.get(i) + 1)),
							storeInfos.get(storeInfos.indexOf(salesInfos.get(i) + 1)), salesInfos.get(i + 1))));
		}
	}
}
