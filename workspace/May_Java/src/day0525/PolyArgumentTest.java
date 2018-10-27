package day0525;


class Product
{
	int price; //��ǰ ����
	int bonusPoint; //��ǰ���� �� �����ϴ� ���ʽ� ����
	
	Product(int price){
		this.price = price;
		bonusPoint =(int)(price/10.0); //���ʽ� ������ ��ǰ���� 10%
		}
}

class Tv extends Product{
Tv(){
	//���� Ŭ���� ������ Product(int price)�� ȣ����//Tv������ 100�������� ��.
	super(100);
}
public String toString() { // ObjectŬ������ toString()�� �������̵� �Ѵ�.
	return "Tv";
}	
}

class Computer extends Product{
	Computer(){
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Buyer{ //��,������ ��� ����
	int money = 1000; //������
public String bonusPoint;
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("¾�� �����ؼ� ����");
			return;
		}
		
		money -= p.price; //���� ������ ������ ��ǰ ������ �A��.
		int bonusPoint = p.bonusPoint; //��ǰ ���ʽ� ������ �߰���.
		System.out.println(p + "��/�� ���� �߳�");
		
	}
	}



public class PolyArgumentTest {
public static void main(String[] args) {
	Buyer b = new Buyer();
	Tv tv = new Tv();
	Computer com = new Computer();
	
	b.buy(tv);
	b.buy(com);
	
	System.out.println("���� ���� ¾��"+ b.money + "�����̴�.");
	System.out.println("���� ���� ¾��"+ b.bonusPoint + "�����̴�.");
		}
}

