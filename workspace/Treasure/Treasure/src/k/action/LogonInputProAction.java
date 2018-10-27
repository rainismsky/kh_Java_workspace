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



public class LogonInputProAction implements CommandAction {//회원가입 처리
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String savePath = "C:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Treasure\\userphoto";
		String savePath1 = "/userphoto/";
		MultipartRequest multi = new MultipartRequest(request, savePath, 10*1024*1024, "utf-8");
		
		
		request.setCharacterEncoding("utf-8");//한글 인코딩
		
		LogonDataBean member = new LogonDataBean();//데이터처리 빈
		String[] checkbox = multi.getParameterValues("interest");

		member.setUser_id(multi.getParameter("user_id"));
		member.setUser_pw(multi.getParameter("user_pw"));
		member.setUser_name(multi.getParameter("user_name"));
		member.setUser_birth(multi.getParameter("user_birth"));
		member.setUser_gender(multi.getParameter("user_gender"));
		member.setUser_phone(multi.getParameter("user_phone"));
		member.setUser_email(multi.getParameter("user_email"));
		member.setUser_pw_hint(multi.getParameter("user_pw"));
		System.out.println(member.getUser_gender());
//		member.setUser_photo(multi.getParameter("user_photo"));
		
        member.setUser_introduction(multi.getParameter("user_introduction"));
        member.setUser_con1(checkbox[0]);
        member.setUser_con2(checkbox[1]);
        member.setUser_con3(checkbox[2]);
       

		member.setUser_grade("bronze");
	    member.setUser_date(new Timestamp(System.currentTimeMillis()));
	    member.setDay_post(0);
	    member.setTotal_like(0);
	    member.setTotal_post(0);
	    
	  //article.setShow_image(multi.getParameter("show_image"));//filePath 저장
		
		
	  		////////////////////////////////////////////////////////////////////
	  		
	  		
	  		String user_photo = multi.getParameter("user_photo");
	  		
	  		File file = multi.getFile("user_photo");
	  		String showImg = multi.getOriginalFileName("user_photo");
	  		System.out.println(showImg);
	  		member.setUser_photo(savePath1+showImg);
	  		
	  		
	  		if(file != null) {
	  			member.setUser_photo(savePath1+file.getName());
	  		} else {
	  			member.setUser_photo("/userphoto/user.png");
	  		}
	  		
	  		
	  		
	  		//////////////////////////
	  		String realFolder="";
	  		String fileSave="fileSave";
	  		
	  		//ServletContext context = getServletContext();
	  		//realFolder=context.getRealPath(fileSave);
	  		//member.setUser_photo(savePath);
	  		Enumeration params = multi.getParameterNames();
	  		//파라미터를 출력한다
	  		while (params.hasMoreElements()) {
	  			String name = (String) params.nextElement(); //전송되는 파라미터이름
	  			String value = multi.getParameter(name); //전송되는 파라미터값  
	  		}
	  		Enumeration files = multi.getFileNames();
	  		while (files.hasMoreElements()) {
	  			String name=(String)files.nextElement();
	  			
	  		}
	  		/*
	  		File file = multi.getFile("show_image");
	  		
	  		
	  		String fileName= multi.getOriginalFileName("show_image");
	  		List<FileItem> items = upload.parseRequest(request);
	  		FileItem item = iter.next();
	  		String realPath=save(item.getInputStream());
	  		article.setShow_Image(realPath);*/
	  		
	  		//////////////////////////////////////////////////////////////////////
	    
	    

	        LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
	        dbPro.insertMember(member);

	        return "/K/inputPro.jsp";//해당 뷰
	    }

	}
