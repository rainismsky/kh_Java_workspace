package ncs.test1;

interface Volume {
	void volumeUp(int level);
	void volumeDown(int level);
}

class Speaker implements Volume {
	int volLevel;
	Speaker(){}
	
	@Override
	public void volumeUp(int level) {
		volLevel += level;
		if(volLevel > 100) {
			volLevel = 100;
		}
		
		System.out.println("Speaker���� �ø��ϴ�." + volLevel);
	}
	
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		if(volLevel < 0) {
			volLevel = 0;
		}
		System.out.println("Speaker���� �����ϴ�." + volLevel);
	}
}

class Radio implements Volume{
	int volLevel;
	Radio(){}
	
	@Override
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println("Radio���� �ø��ϴ�." + volLevel);
	}
	
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		System.out.println("Radio���� �����ϴ�." + volLevel);
	}
	
}

class Tv implements Volume{
	int volLevel;
	Tv(){}
	
	@Override
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println("Tv���� �ø��ϴ�." + volLevel);
	}
	
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		if(volLevel < 0) {
			volLevel = 0;
		}
		System.out.println("Tv���� �����ϴ�." + volLevel);
	}
}

public class VolTest {
	public static void main(String args[]) {
		Volume[] v = new Volume[3]; //InstanceManager.getInstance();
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new Tv();
		
		for(int i=0; i<v.length; i++) {
			for (int j=1;j<=3;j++) {
				v[i].volumeUp(200);
			}
			
			for(int j=1; j<=3; j++) {
				v[i].volumeDown(300);
			}
		}
		
	}
}
