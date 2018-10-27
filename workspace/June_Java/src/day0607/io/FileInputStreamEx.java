package day0607.io;

import java.io.*;

public class FileInputStreamEx {
	public static void main(String args[]) {
		FileInputStream fis = null;
		byte _read[] = new byte[100]; //file�� ���� �о�� �����͸� ������ ����
		byte console[] = new byte[100]; //file��θ� �����ϴ� ����
		try {
			System.out.print("���ϸ� : ");
			System.in.read(console);
			String file = new String(console).trim(); //file�� ��θ� ���ڿ��� �ٲ㼭 �յ� ������ trim()���� �����ؼ� �� ��θ� ���ڿ��� ����
			fis = new FileInputStream(file); //�� ��θ� inputStream���� ����
			fis.read(_read,0,_read.length); //�� ����� ���ϵ����͸� ������ �迭�� �����͸�0���� 100���� ������ ��ȯ
			System.out.println(new String(_read).trim()); //new Stringó���� �ѱ��� �ȱ����� trim()���� ���������� ���
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				if(fis != null) //null�̾ƴϸ� fis����
					fis.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
