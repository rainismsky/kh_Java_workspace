package day0611.net;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	public void start() throws IOException{
		// 포트 7777번을 사용하는 소켓을 생성한다.
		DatagramSocket socket = new DatagramSocket(7777);//데이터그램 소켓부터 만듦
		DatagramPacket inPacket,outPacket;//패킷 두개 선언

		byte[] inMsg = new byte[10];//byte배열 10칸짜리 만듦
		byte[] outMsg; //바이트배열 선언만 해놨음
		
		while(true) { //무한반복 처리
			// 데이터를 수신하기 위한 패킷을 생성한다.
			inPacket = new DatagramPacket(inMsg,inMsg.length);
			//데이터그램패킷에 바이트배열 지정하고,배열의 길이만큼 지정 ->주소와포트 없으니까 받는 생성자
			
			// 패킷을 통해 데이터를 수신(receive)한다.
			socket.receive(inPacket);//클라이언트가 뭔가를 보낼때까지 기다림 . inpacket에 저장함 (0을 1개 보냈으니까 0이저장됨)
			
			// 수신한 패킷으로 부터 client의 IP주소와 Port를 얻는다.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// 서버의 현재 시간을 시분초 형태([hh:mm:ss])로 반환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes();// time을 byte배열로 변환한다.
			
			// 패킷을 생성해서 client에게 전송(send)한다.
			outPacket = new DatagramPacket(outMsg,outMsg.length,address,port);
			socket.send(outPacket);
		}
	}
	public static void main(String[] args) {
		try {
			new UdpServer().start(); // UDP서버를 실행시킨다. start메소드 호출
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
