package j.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import logon.LogonDBBean;
import logon.LogonDataBean;
import logon.MypageDataBean;

public class OtherFeedAction implements CommandAction {//회원정보 수정 페이지 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {

    	request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
    	String user_id = request.getParameter("user_id");
    	
    	
    	LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
		
    	List<Map<String,Object>> articleList = dbPro.Myfeedmain(user_id);
    	List<Map<String,Object>> count = dbPro.Myfeedcount(user_id);
    	List<Map<String,Object>> fowcount = dbPro.Myfollowercount(user_id);
    	List<Map<String,Object>> fowicount = dbPro.Myfollowingcount(user_id);
    	LogonDataBean member =  dbPro.Myfeedmain2(user_id);
    	
    	int followCheck = dbPro.checkfollow(user_id, sessionId);
    	
//		member.setUser_id(request.getParameter("user_id"));
    	
    	request.setAttribute("member", member);
    	request.setAttribute("articleList", articleList);
    	request.setAttribute("count", count);
    	request.setAttribute("fowcount", fowcount);
    	request.setAttribute("fowicount", fowicount);
    	request.setAttribute("followCheck", followCheck);
    	
    	return "/J/other_feed.jsp";//해당 뷰
    }
}

