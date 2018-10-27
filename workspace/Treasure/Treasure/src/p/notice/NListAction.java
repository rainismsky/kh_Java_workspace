package p.notice;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;


public class NListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum"); //������ ��ȣ
		
		HttpSession session=request.getSession();
	    String sessionId=(String)session.getAttribute("memId"); 
	    
		if(pageNum == null) {pageNum = "1";}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize+1; //�� �������� ���۱� ��ȣ
		int endRow = currentPage*pageSize;// �� �������� ������ �۹�ȣ
		int count = 0;
		int number=0;
		
	
		System.out.println("pageNum" + pageNum);
		System.out.println("currentPage" + currentPage);
		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);
	
		List articleList = null;
		NoticeDBBean dbPro = NoticeDBBean.getInstance();//db����
		count = dbPro.getArticleCount();//��ü ���� ��
		if(count > 0) { // ���� �ϳ��� �ִٸ�
			articleList = dbPro.getArticles(startRow, endRow);
		}else { // ���� �Ѱ��� ���ٸ�
			articleList = Collections.EMPTY_LIST;
		}
		
		number = count-(currentPage-1) * pageSize; //�۸�Ͽ� ǥ���� �۹�ȣ

		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("sessionId", sessionId);

		
		
		request.setAttribute("articleList", articleList);

		
		return "/P_notice/n_list.jsp"; // �ش� �� ���� ����
	}

}
