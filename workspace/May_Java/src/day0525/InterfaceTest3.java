package day0525;

class InterfaceTest3 {
	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA(); 
		// ��3�� Ŭ������ �޼��带 ���ؼ� �������̽� I�� ������ Ŭ������ �ν��Ͻ��� ���´�.
	}
}

 class A3 {
    void methodA() {
          I3 i = InstanceManager.getInstance();
		  i.methodB();
     }
 }

 interface I3 {
      public abstract void methodB();
 }

 class B3 implements I3 {
     public void methodB() {
          System.out.println("methodB in B class");
     }
 }

 class InstanceManager { //���� �� ������!
	public static I3 getInstance() {
		return new B3();
	}
 }