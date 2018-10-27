package notice.inquiry_action;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;
import notice.inquiry_action.ContentAction;

public class NoticeAction implements CommandAction { //글목록 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       
        String pageNum = request.getParameter("pageNum");//페이지 번호

        if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 10;//한 페이지의 글의 개수
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
        int count = 0; //페이지 개수
        int number=0;
        
        ArrayList<NoticeDataBean> articleList = null;
        NoticeDBBean dbPro = NoticeDBBean.getInstance();//DB연동
        count = dbPro.getArticle_count();
        System.out.println("!!");
        if (count > 0) {
        	articleList = dbPro.getArticlelist(startRow, endRow);//현재 페이지에 해당하는 글 목록
        } else {
            articleList = (ArrayList<NoticeDataBean>) Collections.EMPTY_LIST;
        }
        System.out.println("@@");
        for(int i=0; i<articleList.size();i++) {
        	System.out.println(articleList.get(i).getN_content());
        }

        number=count-(currentPage-1)*pageSize;//글 목록에 표시할 글번호
        
        //해당 뷰에서 사용할 속성
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "/geunho/notice/Notice_list.jsp";//해당 뷰
    }
}