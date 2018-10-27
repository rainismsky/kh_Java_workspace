package day0607.thread;

import java.io.*;
public class BufferedWriterEx {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("d:\\bufferWriter.txt",true);
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter TEST!!!!");
			bw.newLine();
			bw.write("안녕하냐?" + System.getProperty("line.separator"));
			//문장의 끝을 나타냄.(문장 뒤쪽으로 이어쓰기 불가능)
			
			bw.flush();
		}catch(IOException ioe) {
			ioe.printStackTrace();
			
		}finally {
			try {
					if(fw != null)fw.close();
					if(bw != null)bw.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}
