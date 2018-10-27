package day0608.io;

import java.io.*;

public class InoutStreamReaderEx {
	public static String consoleInput(String input)throws IOException{
		System.out.print(input + " : ");
		InputStreamReader isr = new InputStreamReader(System.in); //화면으로부터 받아옴 system.in
		BufferedReader br = new BufferedReader(isr);
		String message = br.readLine(); //키보드로 입력한 값을 저장
		//isr.close(); //message출력전에 close하면 reader 다 클로즈됨
		return message; //저장한 값 불러옴
	}
	
	public static void main(String[] args)throws IOException{
		String id = consoleInput("id");
		String password = consoleInput("password");
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		out.write("id : " + id  + ", password : " + password);
		out.close();//프로그램 종료하기직전에 close해서 이건 상관없음
	}
}
