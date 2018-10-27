package day0604.collection;

import java.util.Comparator;

public class AbleComp implements Comparator <Able> {
	
	public int compare(Able obj1,Able obj2) {
		int var = 0;
		
		if (obj1.getTotal() > obj2.getTotal())
			var = 1;
		else if(obj1.getTotal() < obj2.getTotal())
			var = -1;
		return var;
	}
}
