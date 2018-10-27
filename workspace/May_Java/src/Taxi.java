
 class Car {
	protected int speed;
	protected String name;

	Car(){
		speed = 0;
		name = null;
	}
	Car(String n){
		name = n;
	}

	public void speedUp(){
		speed +=1;
	}

	public void speedDown(){
		speed -=1;
	}

	public void stop(){
		speed = 0;
	}
	
	public void display(){
		System.out.println("이름 : " + name);
		System.out.println("속도 : " + speed);
	}	

}

class Taxi extends Car{
	private int charge;
	private boolean fare;
	private String company;

	Taxi(String c){
		company = c;
	}

	public void accounts(){
		if(fare == true){
			charge = speed*12;
		}else if(fare ==false) {
			charge = speed*10;
		}
	}

	public void setFare(boolean f){
		fare = f;
	}

	public void display(){
		System.out.println("택시회사 이름 : " + company);
		System.out.println("요금 : " + charge + "원");
		if(fare ==true){
			System.out.println("할증 적용");
		}else {
			System.out.println("할증 아님");
		}
	}
	
	public static void main(String[] args){
		Taxi t = new Taxi("서울택시");
		
		t.setFare(true);
		
		t.speedUp();
		t.speedUp();
		t.accounts();
		t.display();
	
	}
}
