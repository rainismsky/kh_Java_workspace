package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;

public class LogonDeleteFormAction implements CommandAction{

public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
return "/logon2/deleteForm.jsp";
}
}