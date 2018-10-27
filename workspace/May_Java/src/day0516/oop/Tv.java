package day0516.oop;

public class Tv {
	int ch;
	boolean power;
	int vol;
	
	void power() { power = !power; }
	void chUp() {ch++;}
	void chDown() { ch--;}
	void chInput(int channel) {ch = channel;}
	void volUp() {vol++;}
	void volDown() {vol--;}
	
}
