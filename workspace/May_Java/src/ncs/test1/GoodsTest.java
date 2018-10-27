package ncs.test1;

import java.util.Scanner;

class Goods{
	private String name;
	private int price;
	private int quantity;
	
	Goods(){}
	
	Goods(String name,int price,int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public int getTotal() {
		return price * quantity ;
	}
	
	@Override 
	public String toString() {
		return name + ", " + price + "원, " + quantity + "개";
	}
}
public class GoodsTest {
	public static void main(String args[]) {
		Goods g = new Goods();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("다음 항목의 값을 입력하시오.");
		System.out.print("상품명 : ");
		g.setName(scan.nextLine()); 
		System.out.println("가격 : ");
		g.setPrice(scan.nextInt()); //String으로 받은 숫자값을 int로 바꿈
		System.out.println("수량 : ");
		g.setQuantity(scan.nextInt()); 
		
		System.out.println();
		System.out.println("입력된 결과는 다음과 같습니다.");
		System.out.println(g);
		System.out.println("총 구매 가격 : " + g.getTotal() + "원");
	}
}
