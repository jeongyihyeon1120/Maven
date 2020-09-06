package maskApi;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import freemarker.FreeMarkerTemplateEngine;

public class MaskInfo extends MaskShow {

	@Override
	public void maskInfoShow() {
		port(8088);
		ArrayList<Object> jArr = new ArrayList<Object>();
		Map<String, Object> attributes = new HashMap<>();
		get("/mask/show", (request, response) -> {
			InputMaskInfo imi = null;
			ArrayList<String> salesInfos = new ArrayList<String>();
			ArrayList<String> storeInfos = new ArrayList<String>();
			ArrayList<String> maskInfos = new ArrayList<String>();
			int page = 0;
			while (true) {
				System.out.println("sales반복문");
				page++;
				System.out.println("페이지: " + page);
				Document docSales = Jsoup
						.connect("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/sales/json?page=" + page)
						.ignoreContentType(true).get();
				String salesBody = docSales.getElementsByTag("body").text();
				try {
					JSONParser parser = new JSONParser();
					Object objSales = parser.parse(salesBody);
					JSONObject jsonObjSales = (JSONObject) objSales;
					JSONArray salesInfoArray = (JSONArray) jsonObjSales.get("sales");
					if (salesInfoArray.size() == 0 && page != 1) {
						System.out.println("멈춤");
						break;
					}
					for (int i = 0; i < salesInfoArray.size(); i++) {
						// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
						JSONObject salesObject = (JSONObject) salesInfoArray.get(i);
						salesInfos.add(salesObject.get("code").toString());
						salesInfos.add((String) salesObject.get("remain_stat"));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			page = 0;
			while (true) {
				System.out.println("sales반복문");
				page++;
				System.out.println("페이지: " + page);
				Document docStore = Jsoup
						.connect("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + page)
						.ignoreContentType(true).get();
				String storeBody = docStore.getElementsByTag("body").text();
				try {
					
					JSONParser parser = new JSONParser();
					Object objStore = parser.parse(storeBody);
					JSONObject jsonObjStore = (JSONObject) objStore;
					JSONArray storeInfoArray = (JSONArray) jsonObjStore.get("storeInfos");
					if (storeInfoArray.size() == 0 && page != 1) {
						System.out.println("멈춤");
						break;
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

				maskInfos.add(new GsonBuilder().serializeNulls().create()
						.toJson(new InputMaskInfo(storeInfos.get(storeInfos.indexOf(salesInfos.get(i)) + 1),
								storeInfos.get(storeInfos.indexOf(salesInfos.get(i)) + 2), salesInfos.get(i + 1))));
			}
			for (int i = 0; i < maskInfos.size(); i++) {
//				System.out.println(salesInfos.get(j));
//				System.out.println(salesInfos.get(j + 1));
				imi = new Gson().fromJson(maskInfos.get(i), InputMaskInfo.class);
				if(imi.remain_stat == null) {
					imi.remain_stat = "null값 입니다.";
				}
				jArr.add(new InputMaskInfo(imi.name, imi.addr, imi.remain_stat));
			}
			attributes.put("message", jArr);
			return modelAndView(attributes, "maskShow.ftl");
		}, new FreeMarkerTemplateEngine());
	}

}