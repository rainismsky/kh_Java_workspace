package s.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import logon.LogonDataBean;
import s.bean.AdminDBBean;
import s.bean.AuctionDBBean;
import s.bean.AuctionDataBean;

public class AdminUserDetailAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
		String user_id = request.getParameter("user_id");
	       
	        AdminDBBean amdb = AdminDBBean.getInstance();
	        LogonDataBean udb = new LogonDataBean(); 
	        udb = amdb.getUserDetail(user_id);
	        ArrayList userList = new ArrayList();
	      
		
				
		request.setAttribute("memId", sessionId);
		request.setAttribute("udb", udb);		
		
		return "/S/adminUserDetail.jsp";
	}

}
