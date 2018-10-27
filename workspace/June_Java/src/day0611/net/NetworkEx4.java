package day0611.net;

import java.io.*;
import java.net.URL;

public class NetworkEx4 {
	public static void main(String args[]) {
		URL url = null;
		BufferedReader input = null;
		String address = "https://docs.oracle.com/javase/8/docs/api/index.html";  //주소를 일단 문자열에 저장함
		String line = "";
		
		try {
			url = new URL(address); //주소 저장해둔 문자열을 url로 바꿈
			input = new BufferedReader(new InputStreamReader(url.openStream())); //openStream으로 inputStream객체생성
			//InputStreamReader로 2바이트로 늘린 다음에 BufferedReader사용
			
			while((line=input.readLine())!=null) { //읽어온 내용input.readLine()을 line에저장하고 그값이 있다면 출력
				System.out.println(line); 
			}
			input.close(); //닫음
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
