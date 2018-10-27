package s.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import e.list.ShowDBBean;
import j.action.CommandAction;
import s.bean.AdminDBBean;

public class SearchAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		 String pageNum = request.getParameter("pageNum");//페이지 번호
		 String search = request.getParameter("search");//검색어
		String searchOk = request.getParameter("searchOk");
		 String l_category_name = request.getParameter("l_category_name");//대분류
	        if (pageNum == null) {
	            pageNum = "1";
	        }
	        int count = 0;
	        int pageSize = 9;//한 페이지의 글의 개수
	        int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
	        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
	        ShowDBBean dbpro = ShowDBBean.getInstance();
	        List articleList = new ArrayList<>();
	       
	        	articleList = dbpro.getSearchList(startRow, endRow, search, l_category_name);//현재 페이지에 해당하는 글 목록
	        	count = articleList.size();
	       
	        //해당 뷰에서 사용할 속성
	        request.setAttribute("currentPage", new Integer(currentPage));
	        request.setAttribute("startRow", new Integer(startRow));
	        request.setAttribute("endRow", new Integer(endRow));
	        request.setAttribute("count", new Integer(count));
	        request.setAttribute("pageSize", new Integer(pageSize));
		  		
				
		request.setAttribute("articleList", articleList);
		request.setAttribute("search", search);
		request.setAttribute("searchOk", searchOk);
		request.setAttribute("l_category_name", l_category_name);
		
		
		return "/S/searchList.jsp";
	}

}
