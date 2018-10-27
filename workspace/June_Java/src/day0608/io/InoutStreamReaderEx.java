package day0608.io;

import java.io.*;

public class InoutStreamReaderEx {
	public static String consoleInput(String input)throws IOException{
		System.out.print(input + " : ");
		InputStreamReader isr = new InputStreamReader(System.in); //ȭ�����κ��� �޾ƿ� system.in
		BufferedReader br = new BufferedReader(isr);
		String message = br.readLine(); //Ű����� �Է��� ���� ����
		//isr.close(); //message������� close�ϸ� reader �� Ŭ�����
		return message; //������ �� �ҷ���
	}
	
	public static void main(String[] args)throws IOException{
		String id = consoleInput("id");
		String password = consoleInput("password");
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		out.write("id : " + id  + ", password : " + password);
		out.close();//���α׷� �����ϱ������� close�ؼ� �̰� �������
	}
}
