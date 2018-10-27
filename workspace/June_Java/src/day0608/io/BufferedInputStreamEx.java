package day0608.io;
import java.io.*;

public class BufferedInputStreamEx {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream("d:/text.txt");
			bis = new BufferedInputStream(fis); //파일을 읽어올때 버퍼이용해서 읽어올 수 있는 스트림이 만들어짐
			int readbyte = 0;
			while((readbyte = bis.read()) != -1) { //해당값이-1이아니라면, 즉 읽어온값이 있으면
				System.out.print((char)readbyte); //char로 바꿔서 출력
			}//읽어올게 없을때까지~
		}catch(IOException ioe) {
				ioe.printStackTrace();
			}finally {
				try {
					if(fis != null) //fis가 null이 아니라면 즉 객체가 있는 상태라면 (없는데 닫으면 exception)
						fis.close(); //연결시켰던 스트림 닫음
					if(bis != null) //fis하나만 닫아도 되긴 함
						bis.close();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}


//1바이트씩 읽어 오기 떄문에 한글은 깨져서 출력된다.
