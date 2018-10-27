package day0604.util;

import java.util.Comparator;
public class AbleComp implements Comparator<Able> {
	
	@Override
	public int compare(Able obj1,Able obj2) {
		int var = 0;
		if(obj1.getTotal()>obj2.getTotal()) {
			var = 1;
		}else if(obj1.getTotal()<obj2.getTotal()) {
			var = -1;
		}
		
		if(var==0) {
			var = obj1.getEmpno().compareTo(obj2.getEmpno()); //이조건을 주면 ABC순으로
		}
		return var;
	}
}
