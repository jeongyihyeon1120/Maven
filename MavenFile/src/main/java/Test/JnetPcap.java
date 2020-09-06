package Test;

import java.util.ArrayList;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

public class JnetPcap {
	 public static void main( String[] args )
	    {
	        ArrayList<PcapIf> allDevs = new ArrayList<PcapIf>();
	        StringBuilder errbuf = new StringBuilder();
	        
	        int r = Pcap.findAllDevs(allDevs, errbuf);
	        if (r == Pcap.NOT_OK || allDevs.isEmpty()) {
	        	System.out.println("네트워크 장비를 찾을 수 없습니다. " + errbuf.toString());
	        	return;
	        }
	        
	        System.out.println(" [네트워크 장비 탐색 성공] ");
	        int i = 0;
	        for(PcapIf device : allDevs) {
	        	String description = (device.getDescription() != null) ?
	        			device.getDescription() : "장비에 대한 설명이 없습니다.";
	        	System.out.printf("[%d]: &s [%s]\n", i++, device.getDescription(), description);
	        }
	   }
}
