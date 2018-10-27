package day0530.oop;


class Person {
	long id;
	
	/*equals() ::: ��ü�ȿ� ����� Ư�� ���� ���� ������ true,
	�ٸ��� false���� �����ϵ��� �������̵��Ѵ�.*/
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person) {
			return id == ((Person) obj).id; 
			// obj�� ObjectŸ���̹Ƿ� id���� �����ϱ� ���ؼ���
			// PersonŸ������ ����ȯ�� �ʿ��ϴ�.
		
		} else {
			return false; // Ÿ���� Person�� �ƴϸ� ���� ���� �ʿ䵵 ����.
		}
	}

	Person(long id) {
		this.id = id;
	}
}

