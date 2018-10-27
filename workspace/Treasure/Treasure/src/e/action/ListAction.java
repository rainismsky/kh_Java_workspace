package e.action;

import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import e.list.ShowDBBean;
import j.action.CommandAction;

public class ListAction implements CommandAction {//글목록 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       
    	request.setCharacterEncoding("utf-8");

        String pageNum = request.getParameter("pageNum");//페이지 번호
        String l_category_name = request.getParameter("l_category_name");
        String s_category_name = request.getParameter("s_category_name");
      

       
        if (pageNum == null) {
            pageNum = "1";
        }
        System.out.println(pageNum);
        int pageSize = 9;//한 페이지의 글의 개수
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
        int count = 0;
        int number=0;
        /*String s_category_name = request.getParameter("s_category_name");*/
        List articleList = null;
        ShowDBBean dbPro = ShowDBBean.getInstance();//DB연동
        count = dbPro.getArticleCount(s_category_name);//전체 글의 수
        System.out.println("count" + count);
       
        if (count > 0) {
            articleList = dbPro.getArticles(startRow, endRow, s_category_name);//현재 페이지에 해당하는 글 목록
        } else {
            articleList = Collections.EMPTY_LIST;
        }

	number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
        //해당 뷰에서 사용할 속성
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
        request.setAttribute("l_category_name", l_category_name);
        request.setAttribute("s_category_name", s_category_name);
       /*System.out.println("리스트 내용 " + articleList.size());*/
        return "/E/list.jsp";//해당 뷰
    }
}