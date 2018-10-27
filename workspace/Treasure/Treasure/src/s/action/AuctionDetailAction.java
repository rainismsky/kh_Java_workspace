package s.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import j.action.CommandAction;
import s.bean.AuctionDBBean;
import s.bean.AuctionDataBean;

public class AuctionDetailAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");
		int auc_ing_no = Integer.parseInt(request.getParameter("auc_ing_no"));
		String user_id = request.getParameter("user_id");
		
		AuctionDBBean adbb = AuctionDBBean.getInstance(); 
		AuctionDataBean adb = adbb.getAuctionInfo(auc_ing_no, user_id);
	
		/*adbb.MoveToEndAuc();*/
		int countIlike = adbb.countIlike(auc_ing_no);
	
		HashMap bidderMap = new HashMap();
		bidderMap = adbb.getI_Bidder(auc_ing_no, sessionId);
		
		StringTokenizer auc_img = null;
		int lengthimg = 0;
		if(adb.getAuc_image() != null) {
		auc_img = new StringTokenizer(adb.getAuc_image(), ",");
		lengthimg = auc_img.countTokens();
		}
		int check = adbb.checkinterestAuc(auc_ing_no, sessionId);
	
		if(check == 1) {
			request.setAttribute("interesty", "../images/paintedDiaBox.png");
			
			}
		
		else {
			request.setAttribute("interesty", "../images/diabox.png");
			}
		
		
		request.setAttribute("adb", adb);
		request.setAttribute("bidderMap", bidderMap);
		request.setAttribute("memId", sessionId);
		request.setAttribute("userId", user_id);
		request.setAttribute("auc_ing_no", auc_ing_no);
		request.setAttribute("countIlike", countIlike);
		request.setAttribute("lengthimg", lengthimg);
		System.out.println("auctionaction" + sessionId);
		
		return "/S/auctionDetail.jsp";
	}

}
