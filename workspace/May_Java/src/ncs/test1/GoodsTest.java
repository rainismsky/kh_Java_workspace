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
		return name + ", " + price + "��, " + quantity + "��";
	}
}
public class GoodsTest {
	public static void main(String args[]) {
		Goods g = new Goods();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("���� �׸��� ���� �Է��Ͻÿ�.");
		System.out.print("��ǰ�� : ");
		g.setName(scan.nextLine()); 
		System.out.println("���� : ");
		g.setPrice(scan.nextInt()); //String���� ���� ���ڰ��� int�� �ٲ�
		System.out.println("���� : ");
		g.setQuantity(scan.nextInt()); 
		
		System.out.println();
		System.out.println("�Էµ� ����� ������ �����ϴ�.");
		System.out.println(g);
		System.out.println("�� ���� ���� : " + g.getTotal() + "��");
	}
}
