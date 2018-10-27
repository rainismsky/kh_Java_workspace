package day0611.net;

public class MultiClientThread extends Thread {
	private MultiClient mc;

	public MultiClientThread(MultiClient mc) {
		this.mc = mc;
	}

	public void run() {
		String message = null;
		String[] receivedMsg = null;
		boolean isStop = false;
		while (!isStop) {
			try {
				message = (String) mc.getOis().readObject();
				receivedMsg = message.split("#");//#으로 나눔
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(receivedMsg[0] + "," + receivedMsg[1]);
			if (receivedMsg[1].equals("exit")) { //2번째메시지가 exit면
				if (receivedMsg[0].equals(mc.getId())) { //나면 
					mc.exit(); //종료
				} else { //내가아니면 
					mc.getJta().append( 
							receivedMsg[0] + "님이 종료 하셨습니다."
									+ System.getProperty("line.separator"));
					mc.getJta().setCaretPosition(
							mc.getJta().getDocument().getLength());
				}
			} else { //exit가아니면
				mc.getJta().append( //메세지 출력
						receivedMsg[0] + " : " + receivedMsg[1]
								+ System.getProperty("line.separator"));
				mc.getJta().setCaretPosition(
						mc.getJta().getDocument().getLength());
			}
		}
	}
}