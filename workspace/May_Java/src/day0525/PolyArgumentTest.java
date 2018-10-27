package day0525;


class Product
{
	int price; //제품 가격
	int bonusPoint; //제품구매 시 제공하는 보너스 점수
	
	Product(int price){
		this.price = price;
		bonusPoint =(int)(price/10.0); //보너스 점수는 제품가의 10%
		}
}

class Tv extends Product{
Tv(){
	//조상 클래스 생성자 Product(int price)를 호출함//Tv가격을 100만원으로 함.
	super(100);
}
public String toString() { // Object클래스의 toString()을 오버라이딩 한다.
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

class Buyer{ //고객,물건을 사는 새끼
	int money = 1000; //소유금
public String bonusPoint;
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("쩐이 부족해서 못삼");
			return;
		}
		
		money -= p.price; //가진 돈에서 구입한 제품 가격을 뺸다.
		int bonusPoint = p.bonusPoint; //제품 보너스 점수를 추가함.
		System.out.println(p + "을/를 구입 했네");
		
	}
	}



public class PolyArgumentTest {
public static void main(String[] args) {
	Buyer b = new Buyer();
	Tv tv = new Tv();
	Computer com = new Computer();
	
	b.buy(tv);
	b.buy(com);
	
	System.out.println("현재 남은 쩐은"+ b.money + "만원이다.");
	System.out.println("현재 남은 쩐은"+ b.bonusPoint + "만원이다.");
		}
}

