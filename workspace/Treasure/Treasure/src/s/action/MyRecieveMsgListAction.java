package s.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import s.bean.AdminDBBean;
import s.bean.MessageDBBean;

public class MyRecieveMsgListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
		
		 String pageNum = request.getParameter("pageNum");//������ ��ȣ
		 String searchOk = request.getParameter("searchOk");
		 String category = request.getParameter("category");
		 String recieveMsgSearch = request.getParameter("recieveMsgSearch");
		 String recieve_from_id = request.getParameter("recieveMsgSearch");
		 String recieve_subject = request.getParameter("recieveMsgSearch");
		 String recieve_content = request.getParameter("recieveMsgSearch");
		 
		MessageDBBean mdbb = MessageDBBean.getInstance();
		 ArrayList recieveMsgList = new ArrayList();
		 if (pageNum == null) {
	            pageNum = "1";
	        } 
		 int count = 0;
		 int pageSize = 10;//�� �������� ���� ����
	     int currentPage = Integer.parseInt(pageNum);
	     int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
	     int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
	     int recieveMsgListSize = 0;
	     
	     if(category.equals("�������")) {			 
	    	  recieveMsgList = mdbb.recieveMsgSearchFromId(sessionId, recieve_from_id, startRow, endRow);//���� �������� �ش��ϴ� �� ���
		     count = recieveMsgList.size();//��ü ���� ��	
		     recieveMsgListSize = recieveMsgList.size();
		 }
		 if(category.equals("����")) {
			 recieveMsgList = mdbb.recieveMsgSearchSubject(sessionId, recieve_subject, startRow, endRow);//���� �������� �ش��ϴ� �� ���
		     count = recieveMsgList.size();//��ü ���� ��	
		     recieveMsgListSize = recieveMsgList.size();
		 }
		 if(category.equals("ID")) {
			 recieveMsgList = mdbb.recieveMsgSearchContent(sessionId, recieve_content, startRow, endRow);//���� �������� �ش��ϴ� �� ���
		     count = recieveMsgList.size();//��ü ���� ��	
		     recieveMsgListSize = recieveMsgList.size();
		 }else {
			 recieveMsgList = mdbb.recieveMsgList(startRow, endRow, sessionId);//���� �������� �ش��ϴ� �� ���
		     count = recieveMsgList.size();//��ü ���� ��	
		     recieveMsgListSize = recieveMsgList.size();
		 }
	               
	      	       
	        //�ش� �信�� ����� �Ӽ�
	        request.setAttribute("currentPage", new Integer(currentPage));
	        request.setAttribute("startRow", new Integer(startRow));
	        request.setAttribute("endRow", new Integer(endRow));
	        request.setAttribute("count", new Integer(count));
	        request.setAttribute("pageSize", new Integer(pageSize));
		
				
		request.setAttribute("memId", sessionId);
		request.setAttribute("recieveMsgList", recieveMsgList);
		request.setAttribute("recieveMsgListSize", recieveMsgListSize);		
		request.setAttribute("searchOk", searchOk);		
		request.setAttribute("category", category);		
		request.setAttribute("recieveMsgSearch", recieveMsgSearch);		
		
		return "/S/myRecieveMsgList.jsp";
	}

}
