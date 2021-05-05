package Bus;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <pre>
 * Bus 
 * getBusNum.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 20.
 * @author : yhyeon
 * @version : v1.0
 */
public class SetBusNum {
	
	String serviceKey = 
			"yRfxBEk%2F%2BHT9G%2FgrGc7DlsrOifMGwTWUD4eI3kDgp8UbAgilwoc21vxxi4PgMHMxDlPtzeoh0oc1vIgPTKqkXg%3D%3D";
	String url = 
			"http://openapi.gbis.go.kr/ws/rest/busrouteservice?serviceKey=" + serviceKey + "&keyword=";
	
	ArrayList<BusListInput> arrayList;
	
	public SetBusNum(String number) {
		url = url + number;
	}
	
	public SetBusNum() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<BusListInput> setBus() {
		arrayList = new ArrayList<BusListInput>();
		try {
			Connection conn = Jsoup.connect(url);
			Document doc = conn.get();
			Elements eles = doc.select("busRouteList");
			for (Element element : eles) {
				BusListInput busListInput = new BusListInput();
				busListInput.setDistrictCd(element.select("districtCd").text());
				busListInput.setRegionName(element.select("regionName").text());
				busListInput.setRouteId(element.select("routeId").text());
				busListInput.setRouteName(element.select("routeName").text());
				busListInput.setRouteTypeCd(element.select("routeTypeCd").text());
				busListInput.setRouteTypeName(element.select("routeTypeName").text());
				arrayList.add(busListInput);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return arrayList;
		
	}
	
}
