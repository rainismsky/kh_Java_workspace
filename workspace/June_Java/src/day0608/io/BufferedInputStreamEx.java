package day0608.io;
import java.io.*;

public class BufferedInputStreamEx {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream("d:/text.txt");
			bis = new BufferedInputStream(fis); //������ �о�ö� �����̿��ؼ� �о�� �� �ִ� ��Ʈ���� �������
			int readbyte = 0;
			while((readbyte = bis.read()) != -1) { //�ش簪��-1�̾ƴ϶��, �� �о�°��� ������
				System.out.print((char)readbyte); //char�� �ٲ㼭 ���
			}//�о�ð� ����������~
		}catch(IOException ioe) {
				ioe.printStackTrace();
			}finally {
				try {
					if(fis != null) //fis�� null�� �ƴ϶�� �� ��ü�� �ִ� ���¶�� (���µ� ������ exception)
						fis.close(); //������״� ��Ʈ�� ����
					if(bis != null) //fis�ϳ��� �ݾƵ� �Ǳ� ��
						bis.close();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}


//1����Ʈ�� �о� ���� ������ �ѱ��� ������ ��µȴ�.
