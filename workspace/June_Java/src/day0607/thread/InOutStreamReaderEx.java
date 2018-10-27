package day0607.thread;

import java.io.*;

public class InOutStreamReaderEx {
	public static String consoleInput(String input) throws IOException{
		System.out.print(input + ":");
		InputStreamReader isr = new InputStreamReader(System.in); //프로그램 중간에서 끄면 실행안됨 =>(system.in(out));
		BufferedReader br = new BufferedReader(isr);
		String message = br.readLine(); 	// readLine() : 한쭐씩 읽어오는 메소드
		return message;
	}
	
	public static void main(String[] args) throws IOException{
		String id = consoleInput("id");
		String password = consoleInput("password");
		OutputStreamWriter out = new OutputStreamWriter(System.out); //(System.in),(System.out)이 연결되 있으므로 close 안한다.
		out.write("id : " + id + ", password:" + password);
		//out.close(); 
		out.flush(); //out.close(); 안쓸꺼면 flush();라도 써야됨 close();도 똑같다
}
}
