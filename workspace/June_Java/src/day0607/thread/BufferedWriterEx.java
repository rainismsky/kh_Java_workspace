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
			bw.write("�ȳ��ϳ�?" + System.getProperty("line.separator"));
			//������ ���� ��Ÿ��.(���� �������� �̾�� �Ұ���)
			
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
