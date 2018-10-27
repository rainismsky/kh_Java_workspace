package ncs.test;

public class CustomerMain {
	public static void main(String[] args) {
		Customer b = new Customer();
		Noodle nd = new Noodle();
		Rice rc = new Rice();
		
		b.order(nd);
		//System.out.println("국수을/를 주문하셨습니다.");
		b.order(rc);
		//System.out.println("밥을/를 주문하셨습니다.");
		
		System.out.println("현재 남은 돈은 " + b.money + "원 입니다.");
		System.out.println("현재 보너스 점수는 " + b.point + "점 입니다.");
	}
}
class Food {
	int price;
	int point;
	//String name;
	
	Food(int price){ //포인트적립
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
		return "국수";
	}
}

class Rice extends Food{
	Rice(){
		super(2000);
	}
	
	public String getName() {
		return "밥";
	}
	
	
}

class Customer{
	int money=10000;
	int point=0;
	
	Noodle n = new Noodle();
	Rice r = new Rice();
	
	void order(Food f) {
		if(money < f.price) {
			System.out.println("잔액이 부족하여 구매 불가");
			return;
		}
		money -= f.price;
		point += (f.price/10);
		System.out.println(f.getName()+"을/를 주문하셨습니다.");
	}
}
