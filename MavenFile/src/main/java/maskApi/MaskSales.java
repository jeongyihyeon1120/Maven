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

public class MaskSales extends MaskShow {

	@Override
	public void maskInfoShow() {
		port(45678);
		ArrayList<Object> jArr = new ArrayList<Object>();
		Map<String, Object> attributes = new HashMap<>();
		get("/mask/sales/:page", (request, response) -> {
			InputSales is = null;
			ArrayList<String> salesInfos = new ArrayList<String>();
			Document doc = Jsoup.connect(
					"https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/sales/json?page=" + request.params("page"))
					.ignoreContentType(true).get();
			String body = doc.getElementsByTag("body").text();
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(body);
				JSONObject jsonObj = (JSONObject) obj;
				JSONArray salesInfoArray = (JSONArray) jsonObj.get("sales");
				if (salesInfoArray.size() == 0)
					return modelAndView(null, "test.ftl");
				for (int i = 0; i < salesInfoArray.size(); i++) {
					// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
					JSONObject salesObject = (JSONObject) salesInfoArray.get(i);
					salesInfos.add(new GsonBuilder().serializeNulls().create()
							.toJson(new InputSales(salesObject.get("code").toString(),
									(String) salesObject.get("created_at"), (String) salesObject.get("remain_stat"),
									(String) salesObject.get("stock_at"))));
					if (salesObject.get("code").equals("31869475"))
						System.out.println(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			for (int i = 0; i < salesInfos.size(); i++) {
				is = new Gson().fromJson(salesInfos.get(i), InputSales.class);
				jArr.add(new InputSales(is.code, is.created_at, is.remain_stat, is.stock_at));
			}
			attributes.put("message", jArr);
			return modelAndView(attributes, "test1.ftl");
		}, new FreeMarkerTemplateEngine());
	}

}
