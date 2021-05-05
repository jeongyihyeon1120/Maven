package Bus;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;

import freemarker.FreeMarkerTemplateEngine;
import scala.reflect.internal.Trees.New;

/**
 * <pre>
 * Bus 
 * Main.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 20.
 * @author : yhyeon
 * @version : v1.0
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		port(45678);
		get("/bus/:num", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			ArrayList<BusListInput> busListInputs = new ArrayList<BusListInput>();
			SetBusNum setBusNum = new SetBusNum(request.params("num"));
			busListInputs = setBusNum.setBus();

			attributes.put("message", busListInputs);
			return modelAndView(attributes, "bus1.ftl");
		}, new FreeMarkerTemplateEngine());

		get("/routeId/:routeId", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			ArrayList<Object> jArr = new ArrayList<Object>();
			ArrayList<InputBusRouteStationList> busRouteStationLists = new ArrayList<InputBusRouteStationList>();
			List<InputNowBus> inputNowBus = new ArrayList<InputNowBus>();
			SetBusRouteStationList busRouteStationList = new SetBusRouteStationList(request.params("routeId"));
			SetNowBus bus = new SetNowBus(request.params("routeId"));
			busRouteStationLists = busRouteStationList.setBusStationList();
			inputNowBus = bus.NowBus();
			Collections.sort(inputNowBus);
			int count = 0;
			for (InputBusRouteStationList routeStationList : busRouteStationLists) {
				if (count == inputNowBus.size()) {
					jArr.add(new InputNowBusTop(null, null, null, null, null, request.params("routeId"),
							routeStationList.getStationId(), routeStationList.getStationSeq(),
							routeStationList.getStationName()));
				} else {
					if (routeStationList.getStationSeq().equals(inputNowBus.get(count).getStationSeq())) {
						jArr.add(new InputNowBusTop(inputNowBus.get(count).getEndBus(),
								inputNowBus.get(count).getLowPlate(), inputNowBus.get(count).getPlateNo(),
								inputNowBus.get(count).getPlateType(), inputNowBus.get(count).getRemainSeatCnt(),
								inputNowBus.get(count).getRouteId(), inputNowBus.get(count).getStationId(),
								inputNowBus.get(count).getStationSeq(), routeStationList.getStationName()));
						count++;
					} else {
						jArr.add(new InputNowBusTop(null, null, null, null, null, request.params("routeId"),
								routeStationList.getStationId(), routeStationList.getStationSeq(),
								routeStationList.getStationName()));
					}
				}
			}
			attributes.put("message", jArr);
			return modelAndView(attributes, "bus.ftl");
		}, new FreeMarkerTemplateEngine());

		get("/:routeId/:stationId/:staOrder", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			ArrayList<InputBusArrivalService> arrivalServices = new ArrayList<InputBusArrivalService>();
			SetBusArrivalService arrivalService = new SetBusArrivalService(request.params("routeId"),
					request.params("stationId"), request.params("staOrder"));
			arrivalServices = arrivalService.SetBusArrival();
			
			
			attributes.put("message", arrivalServices);
			return modelAndView(attributes, "bus0.ftl");
		}, new FreeMarkerTemplateEngine());
//		
	}

}
