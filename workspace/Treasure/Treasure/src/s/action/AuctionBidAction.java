package s.action;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import j.action.CommandAction;
import s.bean.AuctionDBBean;
import s.bean.AuctionDataBean;

public class AuctionBidAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("AuctionBidAction");
		
		int auc_ing_no = Integer.parseInt(request.getParameter("auc_ing_no"));
		String user_id = request.getParameter("user_id");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");		
		
		int i_bidding_p=0;
		if(!request.getParameter("bidp").equals("")) {
			i_bidding_p=Integer.parseInt(request.getParameter("bidp"));
		}	
		
		AuctionDBBean adbb = AuctionDBBean.getInstance();
		AuctionDataBean adb = adbb.getAuctionInfo(auc_ing_no, user_id);
		
		adbb.bid(auc_ing_no, sessionId, i_bidding_p);
		
		
		HashMap bidderMap = new HashMap();
		bidderMap = adbb.getI_Bidder(auc_ing_no, sessionId);
		StringTokenizer auc_img = new StringTokenizer(adb.getAuc_image(), ",");
		int lengthimg = auc_img.countTokens();
		
		int check = adbb.checkinterestAuc(auc_ing_no, sessionId);
		if(check == 1) {
			request.setAttribute("interesty", "../images/paintedDiaBox.png");
			}
		
		else {
			request.setAttribute("interesty", "../images/diabox.png");
			}
		
		request.setAttribute("adb", adb);
		request.setAttribute("bidderMap", bidderMap);
		request.setAttribute("lengthimg", lengthimg);
		request.setAttribute("memId", sessionId);
		request.setAttribute("user_id", user_id);
		request.setAttribute("auc_ing_no", auc_ing_no);
		
		return "/S/auctionDetail.jsp";
		
	}

}
