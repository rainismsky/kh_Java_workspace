package day0607.thread;

import java.io.*;

public class InOutStreamReaderEx {
	public static String consoleInput(String input) throws IOException{
		System.out.print(input + ":");
		InputStreamReader isr = new InputStreamReader(System.in); //���α׷� �߰����� ���� ����ȵ� =>(system.in(out));
		BufferedReader br = new BufferedReader(isr);
		String message = br.readLine(); 	// readLine() : ���᾿ �о���� �޼ҵ�
		return message;
	}
	
	public static void main(String[] args) throws IOException{
		String id = consoleInput("id");
		String password = consoleInput("password");
		OutputStreamWriter out = new OutputStreamWriter(System.out); //(System.in),(System.out)�� ����� �����Ƿ� close ���Ѵ�.
		out.write("id : " + id + ", password:" + password);
		//out.close(); 
		out.flush(); //out.close(); �Ⱦ����� flush();�� ��ߵ� close();�� �Ȱ���
}
}
