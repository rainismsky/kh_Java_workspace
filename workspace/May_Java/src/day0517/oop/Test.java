package day0517.oop;
public class Test {
	
	//String �����͸� �޾� ����ϴ� �޼ҵ� �ۼ�
	void printText(String text) {
		System.out.println(text);
	} 
	
	//int ������ �ϳ��� �޾� ���� �ϳ� ���� ���� �����ϴ� �޼ҵ�
	int increace(int i) {
		i++;
		return i;
	}
	
	//�迭�� �޾Ƽ� �迭�� �ִ� ��� ���� ���� ����ϴ� �޼ҵ� �ۼ�
	int sum(int[] arr) {
		int sum = 0; //�հ� ����
		for(int i: arr) {
			sum +=i;
		}
		System.out.println("��::"+sum);
		return sum;
	}
	
	//�迭�� �޾Ƽ� �迭�� �ִ� ��� ���� ���� ū �� ����ϴ� �޼ҵ� �ۼ�
	void max(int[] arr) {
		int max = 0; //�ִ밪�� �����Ҽ� �ִ� ���� ����
		for(int i : arr) {
			if(max > max) {
				max = i;
			}
		}
		System.out.println("�ִ밪:"+max);
	}
	
	//�迭�� �޾Ƽ� �迭�� �ִ� ��� ���� ���� ���� �� ����ϴ� �޼ҵ� �ۼ�
	void min(int[] arr) {
		int min = arr[0]; //�ּҰ��� �����Ҽ� �ִ� ���� ����
		for(int i : arr) {
			if(i < min) {
				min = i;
			}
		}
		System.out.println("�ּҰ�::"+min);
	}
	
	//�迭�� �޾Ƽ� �迭�� �ִ� ��� ���� ��� ���
	void avg(int[] arr) {
		
	int total = sum(arr); //�հ� ����
		double avg = (double)total / arr.length;
		System.out.println("��հ�::"+avg);
	}	
		
	public static void main(String[] args) {
	Test t = new Test();
	int[] array = {12,41,36,56};
	//int[] array = {12,41,36,56}
	t.sum(array);
	t.max(array); 
	t.min(array);
	t.avg(array);
	
	}}
	
	
