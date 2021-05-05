package Bus;

import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <pre>
 * Bus 
 * SetBusRouteStationList.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 27.
 * @author : yhyeon
 * @version : v1.0
 */
public class SetBusRouteStationList {
	
	String url;
	String serviceKey = "yRfxBEk%2F%2BHT9G%2FgrGc7DlsrOifMGwTWUD4eI3kDgp8UbAgilwoc21vxxi4PgMHMxDlPtzeoh0oc1vIgPTKqkXg%3D%3D";
	ArrayList<InputBusRouteStationList> arrayList;
	
	public SetBusRouteStationList() {
		
	}
	
	public SetBusRouteStationList(String routeId) {
		url = "http://openapi.gbis.go.kr/ws/rest/busrouteservice/station?serviceKey="+ serviceKey
				+ "&routeId=" + routeId;
	}
	
	public ArrayList<InputBusRouteStationList> setBusStationList() {
		arrayList = new ArrayList<InputBusRouteStationList>();
		try {
			Connection conn = Jsoup.connect(url);
			Document doc = conn.get();
			Elements eles = doc.select("busRouteStationList");
			for (Element element : eles) {
				InputBusRouteStationList busRouteStationList = new InputBusRouteStationList();
				busRouteStationList.setCenterYn(element.select("centerYn").text());
				busRouteStationList.setMobileNo(element.select("mobileNo").text());
				busRouteStationList.setStationId(element.select("stationId").text());
				busRouteStationList.setStationName(element.select("stationName").text());
				busRouteStationList.setStationSeq(element.select("stationSeq").text());
				busRouteStationList.setTurnYn(element.select("turnYn").text());
				busRouteStationList.setX(element.select("x").text());
				busRouteStationList.setY(element.select("y").text());
				arrayList.add(busRouteStationList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
}
