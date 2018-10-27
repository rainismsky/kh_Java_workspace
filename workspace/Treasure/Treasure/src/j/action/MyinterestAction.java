package j.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.show.ShowDBBean;
import j.show.ShowDataBean;
import logon.LogonDBBean;
import logon.LogonDataBean;

public class MyinterestAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		
		LogonDBBean ldbb = LogonDBBean.getInstance();
		LogonDataBean ldb = ldbb.getInterest(sessionId);
		ShowDBBean sdbb = ShowDBBean.getInstance();
		
		request.setAttribute("ldb", ldb);
		
		String con1 = ldb.getUser_con1();
		String con2 = ldb.getUser_con2();
		String con3 = ldb.getUser_con3();
		
		List firstconList = sdbb.getInterestShow(con1);
		List secondconList = sdbb.getInterestShow(con2);
		List thirdconList = sdbb.getInterestShow(con3);
		
		request.setAttribute("firstconList", firstconList);
		request.setAttribute("secondconList", secondconList);
		request.setAttribute("thirdconList", thirdconList);		
		
		System.out.println("myinterestaction : " + secondconList);
		
		return "/J/my_interest.jsp";
	}

}

