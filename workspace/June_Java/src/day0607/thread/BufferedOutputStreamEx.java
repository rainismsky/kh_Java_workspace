package day0607.thread;

import java.io.*;

public class BufferedOutputStreamEx {
public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("d:\\bufferOut.text");
			bos = new BufferedOutputStream(fos);
			String str = "BufferedOutputStream Test!!!!";
			bos.write(str.getBytes());
			bos.flush();   
			
			/*flush : 버퍼가 다차지 않아도 데이터를 비우면서 버퍼를 목적지로 전송한다(중요!),
				 	     버퍼를 사용해 데이터를 사용할때 flush();처리 해줘야 한다.*/
		
		}catch(IOException ie) {
			ie.printStackTrace();
		
		}finally {
			try { 
				if(fos != null)
					fos.close();
				if(bos != null)
					bos.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}
