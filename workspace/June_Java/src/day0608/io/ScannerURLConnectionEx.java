package day0608.io;

import java.net.*;
import java.io.*;
import java.util.*;

public class ScannerURLConnectionEx {
	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner scan = null;
		try {
			urlCon = new URL("http://www.naver.com").openConnection(); //String���� URL�� �ٲ�->openConnection�̿��ؼ� ������ ����
			scan = new Scanner(urlCon.getInputStream()); //urlCon�� ����� ��ü�� 
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
