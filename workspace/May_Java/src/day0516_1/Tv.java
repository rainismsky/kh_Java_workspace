package day0516_1;
//전원,채널 올리기/내리기
public class Tv{
	String color;
	int ch; //현재 채널
	boolean power; //전원 상태
	//볼륨 volume 20
	int volume = 20;
	
	void power() {power = !power; }
	void chUp() {ch++;}
	void chDown() {ch--;}
	void chInput(int channel) {ch = channel;}	
}
