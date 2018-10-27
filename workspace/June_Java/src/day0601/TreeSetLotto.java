package day0601;
import java.util.*;

public class TreeSetLotto {
	public static void main(String[] args) {
		Set set = new TreeSet();

		for (int i = 0; set.size() < 6; i++) { //컬렉션에 저장하고있는 데이터의 개수가 6보다작을때까지만
			int num = (int) (Math.random() * 45) + 1; //1부터 45까지의 범위를 가지는 랜덤함수 발생
			//랜덤한 숫자가 6개가 set에 들어감 
			set.add(new Integer(num));
		}

		System.out.println(set);
	}
}
