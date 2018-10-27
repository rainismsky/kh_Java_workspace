package ncs.test;

public class CustomerMain {
	public static void main(String[] args) {
		Customer b = new Customer();
		Noodle nd = new Noodle();
		Rice rc = new Rice();
		
		b.order(nd);
		//System.out.println("������/�� �ֹ��ϼ̽��ϴ�.");
		b.order(rc);
		//System.out.println("����/�� �ֹ��ϼ̽��ϴ�.");
		
		System.out.println("���� ���� ���� " + b.money + "�� �Դϴ�.");
		System.out.println("���� ���ʽ� ������ " + b.point + "�� �Դϴ�.");
	}
}
class Food {
	int price;
	int point;
	//String name;
	
	Food(int price){ //����Ʈ����
		this.price = price;
		point = (int)(price/10.0);
	}
	
	public String getName() {
		return getName();
		
	}
}

class Noodle extends Food{
	Noodle() {
		super(1000);
	}
	
	public String getName() {
		return "����";
	}
}

class Rice extends Food{
	Rice(){
		super(2000);
	}
	
	public String getName() {
		return "��";
	}
	
	
}

class Customer{
	int money=10000;
	int point=0;
	
	Noodle n = new Noodle();
	Rice r = new Rice();
	
	void order(Food f) {
		if(money < f.price) {
			System.out.println("�ܾ��� �����Ͽ� ���� �Ұ�");
			return;
		}
		money -= f.price;
		point += (f.price/10);
		System.out.println(f.getName()+"��/�� �ֹ��ϼ̽��ϴ�.");
	}
}
