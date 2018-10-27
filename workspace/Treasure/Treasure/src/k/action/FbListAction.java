package k.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.BoardDBBean;

public class FbListAction implements CommandAction {//�۸�� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
        
        String pageNum = request.getParameter("pageNum");//������ ��ȣ
        String search = request.getParameter("search");
        String user_id = request.getParameter("user_id");
        System.out.println("����Ʈ ���Ǿ��̵�");
        System.out.println(user_id);
        int searchn = 0;
        if (pageNum == null) {//�۾��⳪, ���б� �ϰ� ����Ʈ�� ���ư��� �ƴϸ� null ��
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
        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
	    request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "/K/fblist.jsp";//�ش� ��
    }
}