package day0601;
import java.util.*;
public class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int[] score = { 85, 95, 50, 35, 45, 65, 10, 100 };

		for (int i = 0; i < score.length; i++)
			set.add(new Integer(score[i]));

		System.out.println("50���� ���� �� :" 
		+ set.headSet(new Integer(50))); //headset:���ǰ� ã�°�
		System.out.println("50���� ū �� :" 
		+ set.tailSet(new Integer(50))); //tailset:���ǰ�ã�°�
	}
}
