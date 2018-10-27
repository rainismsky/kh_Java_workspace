package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.ItemDataBean;
import manage.ManageDBBean;

public class FileBoardWriteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
        HttpSession session = request.getSession();
        String real_user = (String)session.getAttribute("real_user");
		
        ManageDBBean dbPro = ManageDBBean.getInstance();//DBó��
        String t_name = dbPro.get_t_name(real_user);
        
        request.setAttribute("t_name", t_name);
        
		return "/administer/FileBoardWrite.jsp";
	}
}
