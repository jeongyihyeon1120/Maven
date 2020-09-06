package maskApi;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(1);
		ArrayList<String> storeInfos = new ArrayList<String>();
		Document doc = Jsoup.connect("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=55").ignoreContentType(true).get();
		String body = doc.getElementsByTag("body").text();
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(body);
			JSONObject jsonObj = (JSONObject) obj;
			JSONArray storeInfoArray = (JSONArray) jsonObj.get("storeInfos");
			if(storeInfos.size() == 0) System.out.println("없습니다.");
			for(int i=0; i<storeInfoArray.size(); i++){
				           
                //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
                JSONObject storeObject = (JSONObject) storeInfoArray.get(i);
                 
                //JSON name으로 추출
//                System.out.println("StoreInfo: type==>"+storeObject.get("type"));
//                System.out.println("StoreInfo: name==>"+storeObject.get("name"));
//                System.out.println("StoreInfo: addr==>"+storeObject.get("addr"));
//                System.out.println("StoreInfo: code==>"+storeObject.get("code"));
//                System.out.println("StoreInfo: lat==>"+storeObject.get("lat"));
//                System.out.println("StoreInfo: lng==>"+storeObject.get("lng"));
                storeInfos.add(new GsonBuilder().serializeNulls().create()
						.toJson(new InputStore(storeObject.get("type").toString(),
								storeObject.get("name").toString(), storeObject.get("addr").toString(),
								storeObject.get("code").toString(), storeObject.get("lat").toString(),
								storeObject.get("lng").toString())));
            	System.out.println(storeObject.get("code").getClass().getName());
                if(storeObject.get("code").equals("5038300744")) {
                	System.out.println(2);
                	System.out.println(storeObject.get("code").getClass().getName());
                	System.out.println(storeObject.get("lat").getClass().getName());
                	System.out.println(storeObject.get("lng").getClass().getName());
                	break;
                }
            }
			


		} catch (Exception e) {
			// TODO: handle exception
		}
		InputStore i = null;
		i = new Gson().fromJson(storeInfos.get(0), InputStore.class);
		System.out.println(i);
	}

}
