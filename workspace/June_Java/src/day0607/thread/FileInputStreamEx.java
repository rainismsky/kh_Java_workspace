package day0607.thread;

import java.io.*;

public class FileInputStreamEx{
		public static void main(String arg[]){
		//	FileInputStream fis = null;
			byte _read[] = new byte[100]; //file로 부터 읽어온 데이터를 저장하는 공간 
			byte console[] = new byte[100]; //filepath를 저장할 공간
			
			System.out.print("파일명 : "); //print라서 한글도 깨지지 않음
			try{
				System.in.read(console); 
				//a
				//b
			}catch (IOException e) { //IOException 예외 처리 
				e.printStackTrace();
			}
				String file = new String(console).trim();
				try(FileInputStream fis = new FileInputStream(file);){
				fis.read(_read,0,_read.length);
				System.out.println(new String(_read).trim()); //trim : 앞,뒤 공백제거
			}catch(FileNotFoundException fnfe){
				fnfe.printStackTrace();
			}catch(IOException ie){
				ie.printStackTrace();
			
				/*}finally{
				try{
					if(fis != null) 
						fis.close(); */	
			}
		}
		
}




