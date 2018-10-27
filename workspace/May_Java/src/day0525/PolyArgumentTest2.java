package day0525;

class Product2
{
	int price; //제품가격
	int bonusPoint; //제품 구매시 제공되는 보너스 점수
	
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
	
class Buyer2 { //고객,물건을 사는 사람
	int money = 1000; //소유금 
	int bonusPoint = 0; //보너스점수
	Product2[] item = new Product2[10]; //구입한 제품 저장하기 위한 배열
	int i = 0; //product 배열에 사용될 카운터
	
	void buy(Product2 p) {
		if(money < p.price) {
			System.out.println("쩐이 부족해 물건 못산다.");
		}
		money -= p.price; //가진 돈에서 구입한 제품의 가격을 뺌.
		bonusPoint += p.bonusPoint; //제품 보너스 점수 추가!
		item[i++] = p; //제품 Product[] item에 저장.
		System.out.println(p+"을/를 구입해써!");
		}
	void summary2() { //구매 물품에 대한 정보를 요약해 보여줌.
		int sum = 0; //구입한 물품 가격합계
		String itemList = ""; //구입한 물품 목록
		
		//반복문을 이용해 구입한 물품의 총 가격과 목록 생성.
		for(int i=0; i<item.length;i++) {
			if(item[i]==null) break;
			sum += item[i].price;
			itemList += item[i]+ ",";
		}
		System.out.println("구입한 물품 총액은?"+sum+"만원이다.");
		System.out.println("구입한 제품은?"+itemList+"만원이다.");
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


