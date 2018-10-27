package s.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import s.bean.AdminDBBean;
import s.bean.AuctionDBBean;
import s.bean.AuctionDataBean;

public class AdminReportDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
			
		int show_no = Integer.parseInt(request.getParameter("show_no"));
		String user_id = request.getParameter("user_id");
				
		AdminDBBean amdb = AdminDBBean.getInstance();
		amdb.reportDelete(show_no);
		
		 String pageNum = request.getParameter("pageNum");//������ ��ȣ

	        if (pageNum == null) {
	            pageNum = "1";
	        }
	        int count = 0;
	        int pageSize = 10;//�� �������� ���� ����
	        int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
	        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
	        count = amdb.CountReportList();//��ü ���� ��
	        ArrayList reportList = new ArrayList();
	        if (count > 0) {
	        	reportList = amdb.getReportList(startRow, endRow);//���� �������� �ش��ϴ� �� ���
	        } else {
	        	reportList = (ArrayList) Collections.EMPTY_LIST;
	        }
	       
	        //�ش� �信�� ����� �Ӽ�
	        request.setAttribute("currentPage", new Integer(currentPage));
	        request.setAttribute("startRow", new Integer(startRow));
	        request.setAttribute("endRow", new Integer(endRow));
	        request.setAttribute("count", new Integer(count));
	        request.setAttribute("pageSize", new Integer(pageSize));
		
		int reportSize = reportList.size();		
		request.setAttribute("memId", sessionId);
		request.setAttribute("reportList", reportList);
		request.setAttribute("reportSize", reportSize);	
		
		return "/S/adminReportList.jsp";
	}

}
