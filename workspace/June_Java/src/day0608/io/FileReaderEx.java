package day0608.io;

import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("d://fileIn.txt");
			int readChar;
			while((readChar = fr.read())!=-1) {
				System.out.print((char)readChar);  //1글자씩 가져오니까 한글이깨지지않음
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fr!=null)
					fr.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
/*
 * //read(char[] cbuf) 메서드 사용 char[] cbuf = new char[100]; int totalReadCount =
 * fr.read(cbuf); System.out.println(new String(cbuf));
 * System.out.println("totalReaderCount : "+ totalReadCount);
 */
/*
 * //read(char[] cbuf, int start, int length) char[] b = new char[100]; int
 * totalReadCount = fr.read(b,10,23); System.out.println(new String(b));
 * System.out.println("totalReaderCount : "+ totalReadCount);
 */

