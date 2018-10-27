package day0608.io;
import java.io.*;
public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("d://bufferWriter.txt",true);
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter 테스트입니다.");
			bw.newLine();
			bw.write("안녕하세요" + System.getProperty("line.separator"));
			//문장의 끝을 나타냄.(문장의 뒤쪽으로 이어쓰기 불가능) 
			//true로 이어쓰기하는데  줄바꿔서 이어쓰고싶을 때 사용
			bw.flush();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				if(fw!=null)fw.close();
				if(bw!=null)bw.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
