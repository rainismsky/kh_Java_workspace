package s.action;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import s.bean.AuctionDBBean;
import s.bean.AuctionDataBean;
import s.bean.AuctionDataBean_end;

public class AuctionDetailEndAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int auc_end_no = Integer.parseInt(request.getParameter("auc_end_no"));
		String user_id = request.getParameter("user_id");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
		AuctionDBBean adbb = AuctionDBBean.getInstance();
		
		adbb.MoveToEndAuc();
		HashMap bidderMap = new HashMap();
		bidderMap = adbb.getE_Bidder(auc_end_no, user_id, sessionId);
		AuctionDataBean_end adbe = new AuctionDataBean_end();
		adbe = adbb.getInfoEnd(auc_end_no);
			
		StringTokenizer auc_img = new StringTokenizer(adbe.getAuc_image(), ",");
		int lengthimg = auc_img.countTokens();
					
		
		request.setAttribute("adbe", adbe);
		request.setAttribute("bidderMap", bidderMap);
		request.setAttribute("memId", sessionId);
		request.setAttribute("user_id", user_id);
		request.setAttribute("auc_end_no", auc_end_no);
		request.setAttribute("lengthimg", lengthimg);
		
		return "/S/auctionDetailEnd.jsp";
	}

}
