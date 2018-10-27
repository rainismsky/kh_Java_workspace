package day0608.io;

import java.io.*;
import java.util.*;

public class ScannerFileEx {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(new File("d://scan.txt"));){
			while(scan.hasNextDouble()) {
				System.out.printf("½ºÄµ double : %,.2f %n", scan.nextDouble());
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
