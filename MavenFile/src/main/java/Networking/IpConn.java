package Networking;

import java.net.InetAddress;

public class IpConn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
            // 네이버의 IP 정보를 출력
            InetAddress [] ia = InetAddress.getAllByName("naver.com");
            for(InetAddress imsi : ia){
                System.out.println(" naver IP : "+imsi.getHostAddress());
            }
            // 자신의 IP 출력
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("My PC IP :" + local.getHostAddress());
             
        }catch(Exception e){
            // 예외가 발생했을 때 예외의 내용을 출력
            System.out.println(e.getMessage());
        }
	}

}
