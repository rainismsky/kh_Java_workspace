package day0608.io;

import java.net.*;
import java.io.*;
import java.util.*;

public class ScannerURLConnectionEx {
	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner scan = null;
		try {
			urlCon = new URL("http://www.naver.com").openConnection(); //String값을 URL로 바꿈->openConnection이용해서 도메인 접속
			scan = new Scanner(urlCon.getInputStream()); //urlCon에 연결된 객체를 
			scan.useDelimiter("\\z");
			String text = scan.next();
			System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
	}
}
