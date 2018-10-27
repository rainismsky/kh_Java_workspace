package p.action;
import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import j.action.CommandAction;

public class CreativeMainAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		
		int count = 0;
		//int number=0;
		int third=3;
		List articleList = null;
		ShowDBBean dbPro = ShowDBBean.getInstance();
		count = dbPro.getMainArticleCount();
		
		if(count > 0) { 
			articleList = dbPro.getCreativeMainArticles(third);
		}else { 
			articleList = Collections.EMPTY_LIST;
		}		
		
		request.setAttribute("articleList", articleList);
		
		return "/P/creativeMain.jsp"; 
	}
}