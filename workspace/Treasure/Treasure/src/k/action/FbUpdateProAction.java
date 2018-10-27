package k.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import j.action.CommandAction;
import logon.BoardDataBean;
import logon.LogonDBBean;
import logon.BoardDBBean;

public class FbUpdateProAction implements CommandAction {

    public String requestPro( HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");
        String savePath = "C:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Treasure\\bimage";
		String savePath1 = "/bimage/";
		MultipartRequest multi = new MultipartRequest(request, savePath, 10*1024*1024, "utf-8");
        

        String pageNum = multi.getParameter("pageNum");
        String user_id = multi.getParameter("user_id");

	BoardDataBean article = new BoardDataBean();
        article.setB_no(Integer.parseInt(multi.getParameter("b_no")));
        article.setUser_id(multi.getParameter("user_id"));
        article.setB_title(multi.getParameter("b_title"));
        article.setB_content(multi.getParameter("b_content"));
        article.setB_head(multi.getParameter("b_head"));
	
        
        File file = multi.getFile("uploadFile");
    	
    	
    	if(file != null) {
    		article.setB_image(savePath1+file.getName());
    	} else {
    		article.setB_image(multi.getParameter("b_image"));
    	}
    	
    	BoardDBBean dbPro = BoardDBBean.getInstance();
        int check = dbPro.updateArticle(article);
        
        
        

        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("check", new Integer(check));
        request.setAttribute("user_id", user_id);
System.out.println(user_id);
        return "/K/fbupdatePro.jsp";
    }
}