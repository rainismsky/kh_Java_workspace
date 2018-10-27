package j.action;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.show.ShowDBBean;
import j.show.ShowDataBean;

public class ShowDetailAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		int show_no = Integer.parseInt(request.getParameter("show_no"));
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		String user_id = request.getParameter("user_id");
		
		ShowDBBean sdbb = ShowDBBean.getInstance();
		ShowDataBean sdb = sdbb.getShowInfo(show_no, user_id);
		List hashtagList = sdbb.getHashtag(show_no);
		List lcommentList = sdbb.getLcomment(show_no);
		
		StringTokenizer show_img = new StringTokenizer(sdb.getShow_image(), ",");
		int lengthImg = show_img.countTokens();
		
		int ilikeCheck = sdbb.checkIlike(show_no, sessionId);
		int bookmarkCheck = sdbb.checkBookmark(show_no, sessionId);
		
		if(ilikeCheck == 1) {
			request.setAttribute("likedia", "../images/painteddia.png");
		} else {
			request.setAttribute("likedia", "../images/dia.png");
		}
		if(bookmarkCheck == 1) {
			request.setAttribute("bookmarkbox", "../images/paintedDiaBox.png");
		} else {
			request.setAttribute("bookmarkbox", "../images/diabox.png");
		}
		
		int totalLike = sdbb.countLike(show_no);
		
		request.setAttribute("sdb", sdb);
		request.setAttribute("hashtagList", hashtagList);
		request.setAttribute("lcommentList", lcommentList);
		request.setAttribute("totalLike", totalLike);
		request.setAttribute("lengthImg", lengthImg);
		request.setAttribute("sessionId", sessionId);
		request.setAttribute("l_category_name", sdb.getL_category_name());
		
		System.out.println("totalLike : " + totalLike);
		
		return "/J/show_detail.jsp";
	}

}
