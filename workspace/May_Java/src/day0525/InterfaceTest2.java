package day0525;

	 class A1 {
		    void autoPlay(I i) {
		          i.play();
		     }
		 }

		 interface I {
		      public abstract void play();
		 }

		 class B1 implements I {
		     public void play() {
		          System.out.println
		          ("play in B class");
		     }
		 }

		 class C1 implements I {
		     public void play() {
		          System.out.println("play in C class");
		     }
		 }

		 class InterfaceTest2 {
			public static void main(String[] args) {
				A1 a = new A1();
				a.autoPlay(new B());
				a.autoPlay(new C());
			}
		}
		
		

