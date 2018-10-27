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

public class AdminUserListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
		 String pageNum = request.getParameter("pageNum");//페이지 번호

	        if (pageNum == null) {
	            pageNum = "1";
	        }
	        int count = 0;
	        int pageSize = 10;//한 페이지의 글의 개수
	        int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
	        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
	        AdminDBBean amdb = AdminDBBean.getInstance();
	        count = amdb.CountUserList();//전체 글의 수
	        ArrayList userList = new ArrayList();
	       	userList = amdb.getUserList(startRow, endRow);//현재 페이지에 해당하는 글 목록
	       
	       
	        //해당 뷰에서 사용할 속성
	        request.setAttribute("currentPage", new Integer(currentPage));
	        request.setAttribute("startRow", new Integer(startRow));
	        request.setAttribute("endRow", new Integer(endRow));
	        request.setAttribute("count", new Integer(count));
	        request.setAttribute("pageSize", new Integer(pageSize));
		
		int userListSize = userList.size();		
		request.setAttribute("memId", sessionId);
		request.setAttribute("userList", userList);
		request.setAttribute("userListSize", userListSize);		
		
		return "/S/adminUserList.jsp";
	}

}
