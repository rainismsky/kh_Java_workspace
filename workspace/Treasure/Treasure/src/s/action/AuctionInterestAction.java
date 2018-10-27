package s.action;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import s.bean.AuctionDBBean;
import s.bean.AuctionDataBean;

public class AuctionInterestAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int auc_ing_no = Integer.parseInt(request.getParameter("auc_ing_no"));
		String user_id = request.getParameter("user_id");
				
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");
		AuctionDBBean adbb = AuctionDBBean.getInstance();
		
		AuctionDataBean adb = adbb.getAuctionInfo(auc_ing_no, user_id);
				
		HashMap bidderMap = new HashMap();
		String interestyn = request.getParameter("interestyn"); 
		bidderMap = adbb.getI_Bidder(auc_ing_no, sessionId);
		
		StringTokenizer auc_img = new StringTokenizer(adb.getAuc_image(), ",");
		int lengthimg = auc_img.countTokens();
		int check = adbb.checkinterestAuc(auc_ing_no, sessionId);
		
		if(check == 1) {
			adbb.deleteinterestAuc(auc_ing_no, sessionId);
			request.setAttribute("interesty", "../images/diabox.png");
			
			}
		
		else {
			adbb.insertinterestAuc(auc_ing_no, sessionId);
			request.setAttribute("interesty", "../images/paintedDiaBox.png");
			
			}
		
		System.out.println(interestyn);
		request.setAttribute("adb", adb);
		request.setAttribute("bidderMap", bidderMap);
		request.setAttribute("lengthimg", lengthimg);
		
		request.setAttribute("memId", sessionId);
		request.setAttribute("user_id", user_id);
		request.setAttribute("auc_ing_no", auc_ing_no);
					
		
		return "/S/auctionDetail.jsp";
				
	}

}
