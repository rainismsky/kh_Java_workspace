package p.notice;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;


public class NListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum"); //페이지 번호
		
		HttpSession session=request.getSession();
	    String sessionId=(String)session.getAttribute("memId"); 
	    
		if(pageNum == null) {pageNum = "1";}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize+1; //한 페이지의 시작글 번호
		int endRow = currentPage*pageSize;// 한 페이지의 마지막 글번호
		int count = 0;
		int number=0;
		
	
		System.out.println("pageNum" + pageNum);
		System.out.println("currentPage" + currentPage);
		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);
	
		List articleList = null;
		NoticeDBBean dbPro = NoticeDBBean.getInstance();//db연동
		count = dbPro.getArticleCount();//전체 글의 수
		if(count > 0) { // 글이 하나라도 있다면
			articleList = dbPro.getArticles(startRow, endRow);
		}else { // 글이 한개도 없다면
			articleList = Collections.EMPTY_LIST;
		}
		
		number = count-(currentPage-1) * pageSize; //글목록에 표시할 글번호

		//해당 뷰에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("sessionId", sessionId);

		
		
		request.setAttribute("articleList", articleList);

		
		return "/P_notice/n_list.jsp"; // 해당 뷰 정보 리턴
	}

}
