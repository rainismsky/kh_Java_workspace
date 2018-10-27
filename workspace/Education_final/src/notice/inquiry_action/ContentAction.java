package notice.inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class ContentAction implements CommandAction {// �۳��� ó��
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int N_num = Integer.parseInt(request.getParameter("n_num"));// �ش� �۹�ȣ *DB primary key
		String pageNum = request.getParameter("pageNum");
		
		System.out.println("����Ұ�" + request.getParameter("pageNum"));
		
		System.out.println("�̰�:::::" + Integer.parseInt(request.getParameter("n_num")));
		
		NoticeDBBean dbPro = NoticeDBBean.getInstance();// DBó��
		NoticeDataBean article = dbPro.UpdateGetArticle(N_num);// �ش� �۹�ȣ�� ���� �ش� ���ڵ�
		
		// �ش� �信�� ����� �Ӽ�
		request.setAttribute("n_num",N_num);
		request.setAttribute("pagenum",new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/geunho/notice/content.do";// �ش� ��

	}
}
