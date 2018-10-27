package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class DeleteUserAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
		
		String userid = request.getParameter("u_id");
		System.out.println("�̰� User����Action�� U_id: "+userid);
		
		ManageDBBean dbPro = ManageDBBean.getInstance();
		dbPro.deleteUsers(userid);
		
		return "/administer/UsersManagePro.jsp";
	}
}
