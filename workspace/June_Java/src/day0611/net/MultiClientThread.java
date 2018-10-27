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
				receivedMsg = message.split("#");//#���� ����
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(receivedMsg[0] + "," + receivedMsg[1]);
			if (receivedMsg[1].equals("exit")) { //2��°�޽����� exit��
				if (receivedMsg[0].equals(mc.getId())) { //���� 
					mc.exit(); //����
				} else { //�����ƴϸ� 
					mc.getJta().append( 
							receivedMsg[0] + "���� ���� �ϼ̽��ϴ�."
									+ System.getProperty("line.separator"));
					mc.getJta().setCaretPosition(
							mc.getJta().getDocument().getLength());
				}
			} else { //exit���ƴϸ�
				mc.getJta().append( //�޼��� ���
						receivedMsg[0] + " : " + receivedMsg[1]
								+ System.getProperty("line.separator"));
				mc.getJta().setCaretPosition(
						mc.getJta().getDocument().getLength());
			}
		}
	}
}