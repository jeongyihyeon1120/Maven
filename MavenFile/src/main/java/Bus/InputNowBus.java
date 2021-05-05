package Bus; 

/**
 * <pre>
 * Bus 
 * InputNowBus.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 27.
 * @author : yhyeon
 * @version : v1.0
 */
public class InputNowBus  implements Comparable<InputNowBus>{
	
	private String endBus;
	private String lowPlate;
	private String plateNo;
	private String plateType;
	private String remainSeatCnt;
	private String routeId;
	private String stationId;
	private String stationSeq;
	
	public InputNowBus() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEndBus() {
		return endBus;
	}
	public void setEndBus(String endBus) {
		this.endBus = endBus;
	}
	public String getLowPlate() {
		return lowPlate;
	}
	public void setLowPlate(String lowPlate) {
		this.lowPlate = lowPlate;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getPlateType() {
		return plateType;
	}
	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}
	public String getRemainSeatCnt() {
		return remainSeatCnt;
	}
	public void setRemainSeatCnt(String remainSeatCnt) {
		this.remainSeatCnt = remainSeatCnt;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationSeq() {
		return stationSeq;
	}
	public void setStationSeq(String stationSeq) {
		this.stationSeq = stationSeq;
	}
	
	@Override
	public int compareTo(InputNowBus o) {
		// TODO Auto-generated method stub
		return Integer.parseInt(getStationSeq()) - Integer.parseInt(o.getStationSeq());
	}
}
