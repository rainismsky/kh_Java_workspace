package day0525;

class Product2
{
	int price; //��ǰ����
	int bonusPoint; //��ǰ ���Ž� �����Ǵ� ���ʽ� ����
	
	Product2(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
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
	
class Buyer2 { //��,������ ��� ���
	int money = 1000; //������ 
	int bonusPoint = 0; //���ʽ�����
	Product2[] item = new Product2[10]; //������ ��ǰ �����ϱ� ���� �迭
	int i = 0; //product �迭�� ���� ī����
	
	void buy(Product2 p) {
		if(money < p.price) {
			System.out.println("¾�� ������ ���� �����.");
		}
		money -= p.price; //���� ������ ������ ��ǰ�� ������ ��.
		bonusPoint += p.bonusPoint; //��ǰ ���ʽ� ���� �߰�!
		item[i++] = p; //��ǰ Product[] item�� ����.
		System.out.println(p+"��/�� �����ؽ�!");
		}
	void summary2() { //���� ��ǰ�� ���� ������ ����� ������.
		int sum = 0; //������ ��ǰ �����հ�
		String itemList = ""; //������ ��ǰ ���
		
		//�ݺ����� �̿��� ������ ��ǰ�� �� ���ݰ� ��� ����.
		for(int i=0; i<item.length;i++) {
			if(item[i]==null) break;
			sum += item[i].price;
			itemList += item[i]+ ",";
		}
		System.out.println("������ ��ǰ �Ѿ���?"+sum+"�����̴�.");
		System.out.println("������ ��ǰ��?"+itemList+"�����̴�.");
	}
	
static class PolyArgumentTest2{
	public static void main(String args[]) {
			Buyer2 b = new Buyer2();
			Tv2 tv = new Tv2();
			Computer2 com = new Computer2();
			Audio2 audio = new Audio2();
			b.buy(tv);
			b.buy(com);
			b.buy(audio);
			b.summary2();
	}
}
}


