package day0601;

public class GenEx1 {
	String msg = "GenEx1";
	public String getMsg() {
		return msg;
	}
}

class GenEx2 extends GenEx1{
	String msg = "GenEx2";
	public String getMsg() {
		return msg;
	}
}

class GenEx3 extends GenEx2{
	String msg = "GenEx3";
	public String getMsg() {
		return msg;
	}
}