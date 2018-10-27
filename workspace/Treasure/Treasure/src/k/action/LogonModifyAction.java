package k.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import logon.LogonDBBean;
import logon.LogonDataBean;
import logon.MypageDataBean;

public class LogonModifyAction implements CommandAction {//회원정보 수정 페이지 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {

    	request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
    	
    	
    	LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
		
    	List<Map<String,Object>> articleList = dbPro.Myfeedmain(sessionId);
    	List<Map<String,Object>> count = dbPro.Myfeedcount(sessionId);
    	List<Map<String,Object>> fowcount = dbPro.Myfollowercount(sessionId);
    	List<Map<String,Object>> fowicount = dbPro.Myfollowingcount(sessionId);
    	LogonDataBean member =  dbPro.Myfeedmain2(sessionId);
    	
//		member.setUser_id(request.getParameter("user_id"));
    	
    	request.setAttribute("member", member);
    	request.setAttribute("articleList", articleList);
    	request.setAttribute("count", count);
    	request.setAttribute("fowcount", fowcount);
    	request.setAttribute("fowicount", fowicount);
    	
    	return "/K/myfeedmain.jsp";//해당 뷰
    }
}

