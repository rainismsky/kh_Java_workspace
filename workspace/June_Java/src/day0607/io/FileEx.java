package day0607.io;

import java.io.*;

public class FileEx {
	public static void main(String[] args) throws IOException{
		String filePath = "d:\\";
		File f1 = new File(filePath);
		String list[] = f1.list();
		for(int i=0;i<list.length; i++) {
			File f2 = new File(filePath, list[i]);
			if(f2.isDirectory()) { //f2�� ���丮�� 
				System.out.printf("%s : ���丮 %n",list[i]);
			}else { //f2�� �����̸�
				//%,dbyte :: ,�� �ڸ��� ǥ�� �ڿ� byte����
				System.out.printf("%s : ����(%,dbype)&n",list[i],f2.length());
			}
		}
		File f3 = new File("d:\\test.txt");
		System.out.println(f3.createNewFile()); //true
		System.out.println(f3.getAbsolutePath()); //������ :����̺��ΰ��ҹ���
		System.out.println(f3.getCanonicalPath()); //���԰�� :����̺��ΰ� �빮��
		System.out.println(f3.getPath()); //�׳� getPath()��� �ϸ� ��γ���
		System.out.println(f3.getName()); //�����̸�
		System.out.println(f3.getParent()); //�������
		File f4 = new File("d:\\test.txt"); 
		File f5 = new File("d:\\text1.txt");
		System.out.println(f4.renameTo(f5)); //f4�� �������ִ� ������ �̸��� f5���̸����ιٲ۴�.
		//�� �� �����ϸ� text1.txt�� �̹� �־ �ٲ����ʰ� false�� ������ ������ f4�� test.txt�� �״�� ����
	}
}
