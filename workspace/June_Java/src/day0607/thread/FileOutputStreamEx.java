package day0607.thread;

import java.io.*;

public class FileOutputStreamEx {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			//fos = new FileOutputStream("D:\\fileout.txt,true");
		 fos = new FileOutputStream("D:\\fileout.txt",true);
			
			String message = "HELLO FileOutputStream!!!!!!!!!!";
			fos.write(message.getBytes());
			//fos.close();
			
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();	//e.printStackTrace() : ���� �޼��� �߻� �ٿ����� ã�� �ܰ躰�� ���� ���!(����ϴ� ��������)
		}finally {
			
			try {
				if (fos != null)
					fos.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}

/*TIP e.toString() : ���� �̺�Ʈ�� toString()�� ȣ���ؼ� ������ ���� �޽����� Ȯ����.
    e.getMessage() : ���� �̺�Ʈ�� �Բ� ������ �޽��� 
*/