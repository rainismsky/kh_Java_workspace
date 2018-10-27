package day0607.thread;

import java.io.*;

public class FileOutputStreamEx {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			//fos = new FileOutputStream("D:\\fileout.txt,true");
		 fos = new FileOutputStream("D:\\fileout.txt",true);
			
			String message = "HELLO FileOutputStream!!!!!!!!!!";
			fos.write(message.getBytes());
			//fos.close();
			
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();	//e.printStackTrace() : 에러 메세지 발생 근원지를 찾아 단계별로 에러 출력!(출력하는 역할을함)
		}finally {
			
			try {
				if (fos != null)
					fos.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}

/*TIP e.toString() : 에러 이벤트의 toString()을 호출해서 간단한 에러 메시지를 확인함.
    e.getMessage() : 에러 이벤트와 함께 들어오는 메시지 
*/