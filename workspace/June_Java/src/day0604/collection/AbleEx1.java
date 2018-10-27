package day0604.collection;

import java.util.Arrays;
import java.util.Vector;
import static java.lang.System.out;

class AbleEx1 {
public static void main(String[] args) {
	
		Vector<Able> v = new Vector<Able>(2,5);
		
		Able a1 = new Able("B123",90,75,70);
		Able a2 = new Able("B123",90,75,70);
		Able a3 = new Able("B123",90,75,70);
		Able a4 = new Able("B123",90,75,70);
		v.addElement(a1);
		v.addElement(a2);
		v.addElement(a3);
		v.addElement(a4);

		out.println("-----sortÀü------");
		for(Able n : v)
			out.println(n.empno+","+ n.getTotal());
		
		Able[] a = new Able[v.size()];
		v.copyInto(a);
		AbleComp comp = new AbleComp();
		Arrays.sort(a, comp);
		out.println("-------sort ÈÄ -------");
		
		// v = new Vector<Able>(Arrays.asList(a));
		
		for(Able n : a)
			out.println(n.empno+","+ n.getTotal());
	}
}
