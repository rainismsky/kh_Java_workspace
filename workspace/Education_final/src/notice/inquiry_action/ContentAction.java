package notice.inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class ContentAction implements CommandAction {// 글내용 처리
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int N_num = Integer.parseInt(request.getParameter("n_num"));// 해당 글번호 *DB primary key
		String pageNum = request.getParameter("pageNum");
		
		System.out.println("출력할것" + request.getParameter("pageNum"));
		
		System.out.println("이건:::::" + Integer.parseInt(request.getParameter("n_num")));
		
		NoticeDBBean dbPro = NoticeDBBean.getInstance();// DB처리
		NoticeDataBean article = dbPro.UpdateGetArticle(N_num);// 해당 글번호에 대한 해당 레코드
		
		// 해당 뷰에서 사용할 속성
		request.setAttribute("n_num",N_num);
		request.setAttribute("pagenum",new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/geunho/notice/content.do";// 해당 뷰

	}
}
