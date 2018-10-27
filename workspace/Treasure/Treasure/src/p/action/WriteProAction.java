package p.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.*;

import java.util.Random;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.oreilly.servlet.MultipartRequest;

import j.action.CommandAction;
import j.show.ShowDataBean;

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String savePath = "C:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Treasure\\filesave";

		String savePath2 = "/filesave/";
		MultipartRequest multi = new MultipartRequest(request, savePath, 10 * 1024 * 1024, "UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");

		ShowDataBean article = new ShowDataBean();
		article.setUser_id(sessionId);
		article.setShow_title(multi.getParameter("show_title"));
		article.setShow_content(multi.getParameter("show_content"));
		article.setL_category_name(multi.getParameter("l_category_name"));
		article.setS_category_name(multi.getParameter("s_category_name"));
		article.setShow_sale(multi.getParameter("show_sale"));
		article.setShow_date(new Timestamp(System.currentTimeMillis()));

		System.out.println(multi.getParameter("show_content"));
		////////////////////////////////////////////////////////////////////

		String parameterName = "";
		String showImg = multi.getOriginalFileName("show_image");
		Enumeration imgFile = multi.getFileNames();
		int j = 1;
		int k = 0;
		String filename1 = "";
		String original1 = "";
		String fileNames = "";
		String name1 = "";
		while (imgFile.hasMoreElements()) {
			name1 = (String) imgFile.nextElement();
			
			filename1 += savePath2 + multi.getFilesystemName(name1) + ",";
			original1 += multi.getOriginalFileName(name1)+ ",";
			System.out.println("Filename1 : " + filename1 );
			System.out.println("original1 : " + original1);
			k++;
			
			if(imgFile.hasMoreElements())
				fileNames += name1 + ",";
			else
				fileNames += name1;

		}
		
		article.setShow_image(filename1);
		
		System.out.println("fileNames : " + name1);

		System.out.println("en" + imgFile);
		int i = 0;
		while (imgFile.hasMoreElements()) {

			parameterName += (String) imgFile.nextElement();

			System.out.println("parameterName :" + parameterName);
			System.out.println("value :" + request.getParameter(parameterName));
		}

		
		//article.setShow_image(savePath2 + showImg);

		ShowDBBean dbPro = ShowDBBean.getInstance();
		int show_no = dbPro.insertArticle(article);
		String htag3 = null;
		ArrayList<HashDataBean> hashList = new ArrayList<HashDataBean>();
		System.out.println("mtihtg" + multi.getParameter("h_tag"));

		StringTokenizer htag = new StringTokenizer(multi.getParameter("h_tag"), "#");

		System.out.println("htag" + htag);
		while (htag.hasMoreTokens()) {
			HashDataBean hArticle = new HashDataBean();
			String htag2 = htag.nextToken();
			htag3 = htag2.replaceAll(" ", "");
			hArticle.setH_tag(htag3);
			hashList.add(hArticle);
			System.out.println("htag3" + htag3);
		}
		HashDataBean hArticle = new HashDataBean();
		hArticle.setH_tag(sessionId);
		hashList.add(hArticle);

		HashDBBean hdbPro = HashDBBean.getInstance();
		hdbPro.insertHash(hashList, show_no);

		return "/P/writePro.jsp";
	}

}
