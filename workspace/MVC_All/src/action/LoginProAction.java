package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logon.LogonDBBean;

public class LoginProAction implements CommandAction{
	
public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{

request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");

LogonDBBean dbPro = LogonDBBean.getInstance();
int check=dbPro.userCheck(id,passwd);

request.setAttribute("check",new Integer(check));
request.setAttribute("id",id);

return "/logon2/loginPro.jsp";
}
}
