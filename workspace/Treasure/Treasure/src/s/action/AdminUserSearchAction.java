package s.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import s.bean.AdminDBBean;

public class AdminUserSearchAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
		 String pageNum = request.getParameter("pageNum");//페이지 번호
		 String searchOk = request.getParameter("searchOk");
		 String category = request.getParameter("category");
		 String userSearch = request.getParameter("userSearch");
		 String user_name = request.getParameter("userSearch");
		 String user_grade = request.getParameter("userSearch");
		 String user_id = request.getParameter("userSearch");
		 
		 AdminDBBean amdb = AdminDBBean.getInstance();
		 ArrayList userList = new ArrayList();
		 if (pageNum == null) {
	            pageNum = "1";
	        } 
		 int count = 0;
		 int pageSize = 10;//한 페이지의 글의 개수
	     int currentPage = Integer.parseInt(pageNum);
	     int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
	     int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
	     int userListSize = 0;
	     if(category.equals("이름")) {			 			       
		     userList = amdb.adminSearhName(user_name, startRow, endRow);//현재 페이지에 해당하는 글 목록
		     count = userList.size();//전체 글의 수	
		     userListSize = userList.size();
		 }
		 if(category.equals("등급")) {
			 userList = amdb.adminSearhGrade(user_grade, startRow, endRow);//현재 페이지에 해당하는 글 목록
		     count = userList.size();//전체 글의 수	
		     userListSize = userList.size();
		 }
		 if(category.equals("ID")) {
			 userList = amdb.adminSearhId(user_id, startRow, endRow);//현재 페이지에 해당하는 글 목록
		     count = userList.size();//전체 글의 수	
		     userListSize = userList.size();
		 }
	               
	      	       
	        //해당 뷰에서 사용할 속성
	        request.setAttribute("currentPage", new Integer(currentPage));
	        request.setAttribute("startRow", new Integer(startRow));
	        request.setAttribute("endRow", new Integer(endRow));
	        request.setAttribute("count", new Integer(count));
	        request.setAttribute("pageSize", new Integer(pageSize));
		
				
		request.setAttribute("memId", sessionId);
		request.setAttribute("userList", userList);
		request.setAttribute("userListSize", userListSize);		
		request.setAttribute("searchOk", searchOk);		
		request.setAttribute("category", category);		
		request.setAttribute("userSearch", userSearch);		
		
		System.out.println(userSearch);
		return "/S/adminUserList.jsp";
	}

}
