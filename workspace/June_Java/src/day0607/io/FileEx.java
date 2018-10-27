package day0607.io;

import java.io.*;

public class FileEx {
	public static void main(String[] args) throws IOException{
		String filePath = "d:\\";
		File f1 = new File(filePath);
		String list[] = f1.list();
		for(int i=0;i<list.length; i++) {
			File f2 = new File(filePath, list[i]);
			if(f2.isDirectory()) { //f2가 디렉토리면 
				System.out.printf("%s : 디렉토리 %n",list[i]);
			}else { //f2가 파일이면
				//%,dbyte :: ,로 자릿수 표시 뒤에 byte붙임
				System.out.printf("%s : 파일(%,dbype)&n",list[i],f2.length());
			}
		}
		File f3 = new File("d:\\test.txt");
		System.out.println(f3.createNewFile()); //true
		System.out.println(f3.getAbsolutePath()); //절대경로 :드라이브경로가소문자
		System.out.println(f3.getCanonicalPath()); //정규경로 :드라이브경로가 대문자
		System.out.println(f3.getPath()); //그냥 getPath()라고 하면 경로나옴
		System.out.println(f3.getName()); //파일이름
		System.out.println(f3.getParent()); //상위경로
		File f4 = new File("d:\\test.txt"); 
		File f5 = new File("d:\\text1.txt");
		System.out.println(f4.renameTo(f5)); //f4가 가지고있는 파일의 이름을 f5의이름으로바꾼다.
		//두 번 실행하면 text1.txt가 이미 있어서 바뀌지않고 false가 나오고 생성한 f4의 test.txt가 그대로 있음
	}
}
