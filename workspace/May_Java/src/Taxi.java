
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
		System.out.println("�̸� : " + name);
		System.out.println("�ӵ� : " + speed);
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
		System.out.println("�ý�ȸ�� �̸� : " + company);
		System.out.println("��� : " + charge + "��");
		if(fare ==true){
			System.out.println("���� ����");
		}else {
			System.out.println("���� �ƴ�");
		}
	}
	
	public static void main(String[] args){
		Taxi t = new Taxi("�����ý�");
		
		t.setFare(true);
		
		t.speedUp();
		t.speedUp();
		t.accounts();
		t.display();
	
	}
}
