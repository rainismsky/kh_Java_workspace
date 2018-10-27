package day0525.oop;

class Product2{
	int price;
	int bonusPoint;
	
	Product2(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	Product2(){
		price = 0;
		bonusPoint = 0;
	}
}

class Tv2 extends Product2{
	Tv2(){
		super(100);
	}
	
	public String toString() {
		return "Tv";
	}
}

class Computer2 extends Product2{
	Computer2(){
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
}

class Audio2 extends Product2{
	Audio2(){
		super(50);
	}
	public String toString() {
		return "Audio";
	}
}

class Buyer2{
	int money = 1000;
	int bonusPoint = 0;
	Product2[] item = new Product2[10];
	int i = 0;
	
	void buy(Product2 p) {
		if(money<p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "��(��) �����ϼ̽��ϴ�.");
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for(int i=0; i<item.length; i++) {
			if(item[i] == null) break;
				sum += item[i].price;
				itemList += item[i] + ", ";
				
		}
		
		System.out.println("�����Ͻ� ��ǰ�� �� �ݾ��� " + sum + "�����Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ�� " + itemList + " �Դϴ�.");
		
	}
}

class PolyArgumentTest2 {
	public static void main(String args[]) {
		Buyer2 b = new Buyer2();
		Tv2 tv = new Tv2();
		Computer2 com = new Computer2();
		Audio2 audio = new Audio2();
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
	}
}
