package day0607.thread;

import java.io.*;

public class FileInputStreamEx{
		public static void main(String arg[]){
		//	FileInputStream fis = null;
			byte _read[] = new byte[100]; //file�� ���� �о�� �����͸� �����ϴ� ���� 
			byte console[] = new byte[100]; //filepath�� ������ ����
			
			System.out.print("���ϸ� : "); //print�� �ѱ۵� ������ ����
			try{
				System.in.read(console); 
				//a
				//b
			}catch (IOException e) { //IOException ���� ó�� 
				e.printStackTrace();
			}
				String file = new String(console).trim();
				try(FileInputStream fis = new FileInputStream(file);){
				fis.read(_read,0,_read.length);
				System.out.println(new String(_read).trim()); //trim : ��,�� ��������
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




