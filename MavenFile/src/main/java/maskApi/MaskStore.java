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

public class MaskStore extends MaskShow {
	@Override
	public void maskInfoShow() {
		port(45678);
		ArrayList<InputStore> jArr = new ArrayList<InputStore>();
		Map<String, Object> attributes = new HashMap<>();
		get("/mask/store/:page", (request, response) -> {
			InputStore is = null;
			ArrayList<String> storeInfos = new ArrayList<String>();
			Document doc = Jsoup.connect(
					"https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + request.params("page"))
					.ignoreContentType(true).get();
			String body = doc.getElementsByTag("body").text();
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(body);
				JSONObject jsonObj = (JSONObject) obj;
				JSONArray storeInfoArray = (JSONArray) jsonObj.get("storeInfos");
				if (storeInfoArray.size() == 0) return modelAndView(null, "test.ftl");
				for (int i = 0; i < storeInfoArray.size(); i++) {
					// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
					JSONObject storeObject = (JSONObject) storeInfoArray.get(i);
//					System.out.println(storeObject.get("code"));
//					System.out.println(page);
					if(storeObject.get("lat") == null&&storeObject.get("lng") == null) {
						storeInfos.add(new GsonBuilder().serializeNulls().create()
								.toJson(new InputStore((String)storeObject.get("type"),
										(String)storeObject.get("name"), (String)storeObject.get("addr"),
										storeObject.get("code").toString(), null,
										null)));
						continue;
					}
					
					storeInfos.add(new GsonBuilder().serializeNulls().create()
							.toJson(new InputStore((String)storeObject.get("type"),
									(String)storeObject.get("name"), (String)storeObject.get("addr"),
									storeObject.get("code").toString(), Double.toString((double) storeObject.get("lat")),
									Double.toString((double) storeObject.get("lng")))));
					if(storeObject.get("code").equals("31869475")) System.out.println(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			for (int i = 0; i < storeInfos.size(); i++) {
				is = new Gson().fromJson(storeInfos.get(i), InputStore.class);
				jArr.add(new InputStore(is.type, is.name, is.addr, is.code, is.lat, is.lng));
			}
			attributes.put("message", jArr);
			return modelAndView(attributes, "test.ftl");
		}, new FreeMarkerTemplateEngine());
	}
}
