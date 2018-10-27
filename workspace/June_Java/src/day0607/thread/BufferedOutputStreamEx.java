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
			
			/*flush : ���۰� ������ �ʾƵ� �����͸� ���鼭 ���۸� �������� �����Ѵ�(�߿�!),
				 	     ���۸� ����� �����͸� ����Ҷ� flush();ó�� ����� �Ѵ�.*/
		
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
