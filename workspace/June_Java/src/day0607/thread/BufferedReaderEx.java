package day0607.thread;

import java.io.*;

public class BufferedReaderEx {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			  fr = new FileReader("d:\\test2.txt");
			  br = new BufferedReader(fr);
			  String msg;
			  while((msg = br.readLine()) != null) {
				  System.out.println(msg);
			  }
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fr != null) fr.close();
				if(br != null) br.close();
			
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}
