package day0516_1;
//����,ä�� �ø���/������
public class Tv{
	String color;
	int ch; //���� ä��
	boolean power; //���� ����
	//���� volume 20
	int volume = 20;
	
	void power() {power = !power; }
	void chUp() {ch++;}
	void chDown() {ch--;}
	void chInput(int channel) {ch = channel;}	
}
