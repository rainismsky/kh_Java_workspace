package day0521.oop;
class Tv{
	boolean power; //��������(on/off)
	int channel; //ä��

	void power() { power = !power;}
	void channelUp() {++ channel;}
	void channelDown() { --channel; }
	//���� ���� ���� ,ä�� ���� ����϶�!
	//void �����ϴ� ���� : �����ϴ� ���� ������ �⺻�ڷ��� ��� void�����Ѵ�!!
	
	
public String toString() {
return "��������:"+power+" ���� ä��:"+channel;
}

}
class CaptionTv extends Tv{
	CaptionTv(){}
	boolean caption; //ĸ�ǻ��� (on/off(
	void displayCaption(String text) { //�ؽ�Ʈ �ּҰ��� �ؿ� �ؽ�Ʈ�� ����
		if (caption) { //ĸ�� ���°� on(true)�� ���� text�� ���� �ش�.
			System.out.println(text);
		}
	}
}

public class CaptionTvTest {
public static 
void main(String[] args) {
	Tv t = new Tv();
	System.out.println(t);
	
	CaptionTv ctv = new CaptionTv(); //���� Ŭ�����κ��� ��ӹ��� ���
	ctv.channel = 10; 				// ���� Ŭ�����κ��� ��ӹ��� ���
	ctv.channelUp();
	System.out.println(ctv.channel);
	ctv.displayCaption("Hello, world"); //ĸ�� ����� �Ҵ�.
	ctv.caption = true;
	ctv.displayCaption("Hello, World"); // ĸ���� ȭ�鿡 ���� �ش�.
}
}
