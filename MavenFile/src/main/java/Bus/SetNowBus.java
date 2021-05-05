package Bus;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <pre>
 * Bus 
 * SetNowBus.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 27.
 * @author : yhyeon
 * @version : v1.0
 */
public class SetNowBus {
	
	String serviceKey = "1234567890";
	String url = "http://openapi.gbis.go.kr/ws/rest/buslocationservice?serviceKey=" + 1234567890 + "&routeId=";
	
	private List<InputNowBus> arrayList;
	
	public SetNowBus() {
		// TODO Auto-generated constructor stub
	}
	
	public SetNowBus(String routeId) {
		url = url + routeId;
	}
	
	public List<InputNowBus> NowBus() {
		arrayList = new ArrayList<InputNowBus>();
		try {
			Connection conn = Jsoup.connect(url);
			Document doc = conn.get();
			Elements eles = doc.select("busLocationList");
			for (Element element : eles) {
				InputNowBus bus = new InputNowBus();
				bus.setEndBus(element.select("endBus").text());
				bus.setLowPlate(element.select("lowPlate").text());
				bus.setPlateNo(element.select("plateNo").text());
				bus.setPlateType(element.select("plateType").text());
				bus.setRemainSeatCnt(element.select("remainSeatCnt").text());
				bus.setRouteId(element.select("routeId").text());
				bus.setStationId(element.select("stationId").text());
				bus.setStationSeq(element.select("stationSeq").text());
				arrayList.add(bus);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrayList;
	}
	
}
