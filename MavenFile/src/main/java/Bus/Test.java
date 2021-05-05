package Bus; 

/**
 * <pre>
 * Bus 
 * Test.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 9. 27.
 * @author : yhyeon
 * @version : v1.0
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetBusNum busNum = new SetBusNum("21");
		for (BusListInput busListInput : busNum.setBus()) {
//			System.out.println(busListInput.getDistrictCd());
			System.out.println(busListInput.getRegionName());
		}
		
	}

}
