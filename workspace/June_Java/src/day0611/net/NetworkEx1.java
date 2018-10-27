package day0611.net;
import java.net.*;
import java.util.*;

public class NetworkEx1 {
	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress [] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() :" + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostName());
			System.out.println("toString() : " + ip);
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress() : " + Arrays.toString(ipAddr)); //배열에있는걸 toString으로 가져와서 출력
			//byte로 가져와서 범위 밖인 경우 음수로 출력됨
			
			String result = "";
			for(int i=0;i<ipAddr.length; i++) { //음수로 출력되지않도록 처리
				result += (ipAddr[i] <0)? ipAddr[i] + 256 : ipAddr[i]; //0보다 작으면(음수면) 256 더해서 출력하고, 0보다 크면(양수면)그냥 출력
				result += ".";
			}
			System.out.println("getAddress() + 256 :"+result); //256더한 주소는 ~ (양수로 출력되게 한 것을 따로 출력)
			System.out.println();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			System.out.println();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for(int i=0; i<ipArr.length; i++) {
				System.out.println("ipArr[" + i + "] : "+ ipArr[i]);
			}
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
