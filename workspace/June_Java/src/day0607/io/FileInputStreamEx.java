package day0607.io;

import java.io.*;

public class FileInputStreamEx {
	public static void main(String args[]) {
		FileInputStream fis = null;
		byte _read[] = new byte[100]; //file로 부터 읽어온 데이터를 저장할 공간
		byte console[] = new byte[100]; //file경로를 저장하는 공간
		try {
			System.out.print("파일명 : ");
			System.in.read(console);
			String file = new String(console).trim(); //file의 경로를 문자열로 바꿔서 앞뒤 공백을 trim()으로 제거해서 딱 경로만 문자열에 저장
			fis = new FileInputStream(file); //그 경로를 inputStream으로 넣음
			fis.read(_read,0,_read.length); //그 경로의 파일데이터를 저장한 배열의 데이터를0부터 100까지 저장후 반환
			System.out.println(new String(_read).trim()); //new String처리로 한글이 안깨지고 trim()으로 공백제거후 출력
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				if(fis != null) //null이아니면 fis닫음
					fis.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
