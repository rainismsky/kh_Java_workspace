package k.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import j.action.CommandAction;
import logon.BoardDBBean;
import logon.BoardDataBean;

public class FbWriteProAction implements CommandAction {// 입력된 글 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
System.out.println("라이트프로 진입");
        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        
        
        String savePath = "C:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Treasure\\bimage";
		String savePath1 = "/bimage/";
		MultipartRequest multi = new MultipartRequest(request, savePath, 10*1024*1024, "utf-8");
       
        BoardDataBean article = new BoardDataBean();//데이터처리 빈
        article.setB_category(Integer.parseInt(multi.getParameter("b_category")));
        article.setB_head(multi.getParameter("b_head"));
        article.setB_title(multi.getParameter("b_title"));
	    article.setB_view(0);
	    System.out.println();
        article.setUser_id(multi.getParameter("user_id"));
        article.setB_content(multi.getParameter("b_content"));
        article.setB_date(new Timestamp(System.currentTimeMillis()));
        
	    String b_image = multi.getParameter("b_image");
  		
  		File file = multi.getFile("b_image");
  		String showImg = multi.getOriginalFileName("b_image");
  		System.out.println(showImg);
  		article.setB_image(savePath1+showImg);
  		
  		
  		if(file != null) {
  			article.setB_image(savePath1+file.getName());
  		} else {
  			article.setB_image("");
  		}
  		
		System.out.println("-----------------------------------");
		System.out.println(article.getB_category());
		System.out.println(article.getB_head());
		System.out.println(article.getB_title());
		System.out.println(article.getB_view());
		System.out.println(article.getUser_id());
		System.out.println(article.getB_content());
		System.out.println(article.getB_image());
		System.out.println(article.getB_date());
  		
  		
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
  		System.out.println("45444444444.");
  		
        BoardDBBean dbPro = BoardDBBean.getInstance();//DB처리
        dbPro.insertArticle(article);
        /*int x = dbPro.getArticleCount();*/

        
        System.out.println("123123123123입니다.");
        
        return "/K/fbwritePro.jsp";
    }
}