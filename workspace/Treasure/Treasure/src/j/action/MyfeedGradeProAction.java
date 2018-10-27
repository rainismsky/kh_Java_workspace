package j.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;
import logon.MypageDataBean;

public class MyfeedGradeProAction implements CommandAction {//회원정보 수정 페이지 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {

    	request.setCharacterEncoding("utf-8");
    	String user_id = request.getParameter("user_id");
    	System.out.println(user_id);
    	LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
    	
    	MypageDataBean gradeop =  dbPro.Myfeedgradeoption(user_id);
    	
    	request.setAttribute("gradeop", gradeop);
    	
    	System.out.println(gradeop);
    	return "/J/myfeedgrade.jsp";//해당 뷰
    }
}
