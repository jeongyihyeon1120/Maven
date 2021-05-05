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
 * SetBusArrivalService.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 10. 4.
 * @author : yhyeon
 * @version : v1.0
 */
public class SetBusArrivalService {

	String serviceKey = "1234567890";
	String url;
	ArrayList<InputBusArrivalService> arrayList;

	public SetBusArrivalService(String routeId, String stationId, String staOrder) {
		url = "http://openapi.gbis.go.kr/ws/rest/busarrivalservice?serviceKey=" + serviceKey
				+ "&stationId=" + stationId
				+ "&routeId=" + routeId
				+ "&staOrder=" + staOrder;
	}
	
	public ArrayList<InputBusArrivalService> SetBusArrival() {
		arrayList = new ArrayList<InputBusArrivalService>();
		try {
			Connection conn = Jsoup.connect(url);
			Document doc = conn.get();
			Elements eles = doc.select("busArrivalItem");
			for (Element element : eles) {
				InputBusArrivalService arrivalService = new InputBusArrivalService();
				arrivalService.setLocationNo1(element.select("locationNo1").text());
				arrivalService.setLocationNo2(element.select("locationNo2").text());
				arrivalService.setPredictTime1(element.select("predictTime1").text());
				arrivalService.setPredictTime2(element.select("predictTime2").text());				arrivalService.setFlag(element.select("flag").text());
				arrivalService.setRemainSeatCnt1(element.select("remainSeatCnt1").text());
				arrivalService.setRemainSeatCnt2(element.select("remainSeatCnt2").text());
				arrayList.add(arrivalService);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
}
