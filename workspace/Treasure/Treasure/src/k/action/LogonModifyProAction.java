package k.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

import javax.servlet.*;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.oreilly.servlet.MultipartRequest;

import j.action.CommandAction;
import logon.LogonDBBean;
import logon.LogonDataBean;

public class LogonModifyProAction implements CommandAction {//회원정보수정 처리

    public String requestPro( HttpServletRequest request,HttpServletResponse response) throws Throwable {

    	String savePath = "C:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Treasure\\userphoto";
		String savePath1 = "/userphoto/";
		MultipartRequest multi = new MultipartRequest(request, savePath, 10*1024*1024, "utf-8");
    	
		
    	request.setCharacterEncoding("utf-8");
        
        String user_id = multi.getParameter("user_id");


	LogonDataBean member = new LogonDataBean();
	String[] checkbox = multi.getParameterValues("interest");
	
	
	member.setUser_id(multi.getParameter("user_id"));
	member.setUser_pw(multi.getParameter("user_pw"));
	member.setUser_name(multi.getParameter("user_name"));
	member.setUser_birth(multi.getParameter("user_birth"));
	member.setUser_gender(multi.getParameter("user_gender"));
	member.setUser_phone(multi.getParameter("user_phone"));
	member.setUser_email(multi.getParameter("user_email"));
	member.setUser_pw_hint(multi.getParameter("user_pw_hint"));
	member.setUser_introduction(multi.getParameter("user_introduction"));
	member.setUser_con1(checkbox[0]);
	member.setUser_con2(checkbox[1]);
	member.setUser_con3(checkbox[2]);
	
	
	
		
	File file = multi.getFile("uploadFile");
	
	
	if(file != null) {
		member.setUser_photo(savePath1+file.getName());
	} else {
		member.setUser_photo(multi.getParameter("user_photo"));
	}
	
	LogonDBBean dbPro = LogonDBBean.getInstance();
        dbPro.updateMember(member, user_id);
        
        
        return "/K/modifyPro.jsp";//해당 뷰
    }
}
