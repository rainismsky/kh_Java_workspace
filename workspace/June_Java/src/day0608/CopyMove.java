package day0608.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyMove {
	public static void main(String[] args) {
		File file = null;
		File newFile = null;
		
		FileReader fr = null;
		BufferedReader br = null;
		String msg ="";
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
		file = new File("C:\\su\\copy.txt");
		fr = new FileReader(file);	
		br = new BufferedReader(fr);
		newFile = new File("d:\\", file.getName());
		fw = new FileWriter(newFile);
		bw = new BufferedWriter(fw);
		while((msg = br.readLine()) != null) {
			bw.write(msg);
		}
		bw.flush();
		
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}




