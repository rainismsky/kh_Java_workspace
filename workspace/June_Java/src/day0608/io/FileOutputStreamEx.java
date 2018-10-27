package day0608.io;
import java.io.*;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			//fos = new FileOutputStream("d://fileout.txt");
			fos = new FileOutputStream("d://fileout.txt",true);

			String message = "Hello FileOutputStream!";
			fos.write(message.getBytes());
			//write로 받으려면 문자열을 byte배열로 바꿔야해서 getBytes()이용
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				if(fos!=null)
					fos.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
