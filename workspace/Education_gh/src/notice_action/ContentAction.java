package notice_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;


public class ContentAction implements CommandAction {//글내용 처리
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
    	
        int N_num = Integer.parseInt(request.getParameter("n_num"));//해당 글번호 *DB primary key
        
     /*   String N_subject = request.getParameter("n_subject");//해당 글 제목
        String N_content = request.getParameter("n_content");//해당 글 내용
        String pageNum = request.getParameter("pageNum");//해당 페이지 번호
*/        
        System.out.println("이건:::::"+Integer.parseInt(request.getParameter("n_num")));
        System.out.println(request.getParameter("n_subject"));
        System.out.println(request.getParameter("n_content"));
        System.out.println(request.getParameter("pageNum"));
        
        NoticeDBBean dbPro = NoticeDBBean.getInstance();//DB처리
        NoticeDataBean article =  dbPro.updateGetArticle(N_num);//해당 글번호에 대한 해당 레코드
    
        //해당 뷰에서 사용할 속성
        request.setAttribute("n_num", new Integer(N_num));//받아올 해당 글 번호 *DB primary key

        return "/geunho/notice/content.jsp";//해당 뷰
   
}
}

