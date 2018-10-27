package day0611.net;
import java.net.*;
import java.io.*;

public class UdpClient {
	public void start() throws IOException, UnknownHostException{
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("192.168.50.49");//inetAdrress객체로 바꿔서 저장
		
		// 데이터가 저장될 공간으로 byte배열을 생성한다.
		byte[] msg = new byte[100];//100칸짜리 byte배열에 0이 저장되어있음
		
		DatagramPacket outPacket = new DatagramPacket(msg,1,serverAddress,7777);
		//100칸짜리 바이트배열에서 1개 보냄 ip주소와 포트번호로..->보내는생성자
		DatagramPacket inPacket = new DatagramPacket(msg,msg.length);
		//주소가없으므로 해당 길이만큼 받아서 저장하겠다 라는 생성자
		
		datagramSocket.send(outPacket);   // DatagramPacket을 전송한다. 해당ip와 포트번호갖고있는애한테 패킷을 보냄
		datagramSocket.receive(inPacket); // DatagramPacket을 수신한다. 

		System.out.println("current server time :" + new String(inPacket.getData())); //data만 꺼내서 String으로 ... 출력

		datagramSocket.close(); //닫음
	} // start()

	public static void main(String args[]) {
		try {
			new UdpClient().start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main 
}