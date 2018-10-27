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
		
		 String pageNum = request.getParameter("pageNum");//페이지 번호
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
		 int pageSize = 10;//한 페이지의 글의 개수
	     int currentPage = Integer.parseInt(pageNum);
	     int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
	     int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
	     int recieveMsgListSize = 0;
	     
	     if(category.equals("보낸사람")) {			 
	    	  recieveMsgList = mdbb.recieveMsgSearchFromId(sessionId, recieve_from_id, startRow, endRow);//현재 페이지에 해당하는 글 목록
		     count = recieveMsgList.size();//전체 글의 수	
		     recieveMsgListSize = recieveMsgList.size();
		 }
		 if(category.equals("제목")) {
			 recieveMsgList = mdbb.recieveMsgSearchSubject(sessionId, recieve_subject, startRow, endRow);//현재 페이지에 해당하는 글 목록
		     count = recieveMsgList.size();//전체 글의 수	
		     recieveMsgListSize = recieveMsgList.size();
		 }
		 if(category.equals("ID")) {
			 recieveMsgList = mdbb.recieveMsgSearchContent(sessionId, recieve_content, startRow, endRow);//현재 페이지에 해당하는 글 목록
		     count = recieveMsgList.size();//전체 글의 수	
		     recieveMsgListSize = recieveMsgList.size();
		 }else {
			 recieveMsgList = mdbb.recieveMsgList(startRow, endRow, sessionId);//현재 페이지에 해당하는 글 목록
		     count = recieveMsgList.size();//전체 글의 수	
		     recieveMsgListSize = recieveMsgList.size();
		 }
	               
	      	       
	        //해당 뷰에서 사용할 속성
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
