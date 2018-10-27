package day0601.collection;

import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args){
		Vector<Double> v = new Vector<Double>(2,5);
		
		//�ڿ��߰�
		v.add(100.3); //0
		v.add(3.14); //1
		v.addElement(1000.); //2
		for(Double n : v)
			System.out.println(n); //�߰��� ��ҵ� ���
		
		//�ڿ��˻�
		double search = 1000.0;	//�˻��� ��� 
		int index = v.indexOf(search);	//�˻� /2 
		//indexOf:�ִ��� ������ �Ǵܿ��ο����ε� ���� �����.������ ��Ұ� Vector������� �˻�.
		
		if(index != -1)
			System.out.println("�˻����" + search+"�� ��ġ :"+ index);
		else
			System.out.println("�˻����" + search + "�� ������");
		
		System.out.println("::���� �� �뷮/ũ�� Ȯ��::");
		System.out.println("capacity : " + v.capacity()); //7
		System.out.println("size : " + v.size()); //3
		
		//�ڿ�����
		double del = 3.14; //������ ���
		if(v.contains(del)) {	//������ ��Ұ� Vector�� ������� �˻�
			v.remove(del); //����
		}
	}
}

