package day0607.thread;

import java.io.*;

public class FileReaderEx {
public static void main(String[] args) {
		FileReader fr = null;
		
		try {
			fr = new FileReader("d:\\fileln.txt");
			int readChar;
			while ((readChar = fr.read())!= -1) {
				System.out.println((char)readChar);
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
