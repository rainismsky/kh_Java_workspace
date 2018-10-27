package k.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.BoardDBBean;

public class FbListAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
        
        String pageNum = request.getParameter("pageNum");//페이지 번호
        String search = request.getParameter("search");
        String user_id = request.getParameter("user_id");
        System.out.println("리스트 세션아이디");
        System.out.println(user_id);
        int searchn = 0;
        if (pageNum == null) {//글쓰기나, 글읽기 하고 리스트로 돌아갈때 아니면 null 값
            pageNum = "1";
        }
        
        if(search == null)
    	{
    		search = "";
    	}
    	else
    	{
    		searchn = Integer.parseInt(request.getParameter("searchn"));
    	}
        
        int pageSize = 10;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage * pageSize) - (pageSize-1); //1
    	int endRow = currentPage * pageSize; //10
    	int count = 0;
    	int number = 0;

    	List articleList = null;
    	BoardDBBean dbPro = BoardDBBean.getInstance();
    	
    	if(search.equals("") || search == null)
    		count = dbPro.getArticleCount();
    	else
    		count = dbPro.getArticleCount(searchn,search);
    	
    	if(count > 0)
    	{
    		if(search.equals("") || search == null)
    			articleList = dbPro.getArticles(startRow, endRow);
    	
    		else
    			articleList = dbPro.getArticles(startRow, endRow, searchn, search);
    	
    			
    	}
    	number = count-(currentPage - 1) * pageSize;
    			// 11 -(2-1) *3 = 8
        //해당 뷰에서 사용할 속성
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
	    request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "/K/fblist.jsp";//해당 뷰
    }
}