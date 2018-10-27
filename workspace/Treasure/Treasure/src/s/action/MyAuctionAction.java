package s.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.SessionIdGenerator;

import j.action.CommandAction;
import s.bean.AuctionDBBean;
import s.bean.AuctionDataBean;
import s.bean.AuctionDataBean_end;

public class MyAuctionAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");	
		String myAuction = null; 
		String tab = request.getParameter("tab");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");
		
		if (tab==null || tab=="") {
			tab = "경매가능";
		}
		
		AuctionDBBean adbb = AuctionDBBean.getInstance();
		AuctionDataBean adb = new AuctionDataBean();
		AuctionDataBean_end adbe = new AuctionDataBean_end();

		ArrayList aucOkList = new ArrayList();
		ArrayList sailingList = new ArrayList();
		ArrayList sailEndList = new ArrayList();
		ArrayList buyingList = new ArrayList();
		ArrayList buyEndList = new ArrayList();
		ArrayList interestAucList = new ArrayList();
		adbb.MoveToEndAuc();
		
		if(tab.equals("경매가능")) {
			aucOkList = adbb.getInfoAucOk(sessionId);
			request.setAttribute("aucOkList", aucOkList);
			
			myAuction = "/S/MyAucOkAuction.jsp";
		}else if(tab.equals("판매")) {
			sailingList = adbb.getInfoSailing(sessionId);
			sailEndList = adbb.getInfoSailEnd(sessionId);
			 String ssingPageNum = request.getParameter("singPageNum");  
			 if (ssingPageNum == null || ssingPageNum == "") {
				 ssingPageNum = "1";
		        }
			int singPageNum = Integer.parseInt(ssingPageNum);
			 String ssEndPageNum = request.getParameter("sEndPageNum");//페이지 번호  
			 if (ssEndPageNum == null || ssEndPageNum == "") {
				 ssEndPageNum = "1";
		        }
			int sEndPageNum = Integer.parseInt(ssEndPageNum);
			request.setAttribute("sEndPageNum", sEndPageNum);
			request.setAttribute("singPageNum", singPageNum);
			int sailingSize = sailingList.size();
			int sailEndSize = sailEndList.size();
			request.setAttribute("sailingList", sailingList);
			request.setAttribute("sailEndList", sailEndList);
			request.setAttribute("sailingSize", sailingSize);
			request.setAttribute("sailEndSize", sailEndSize);
			
			myAuction = "/S/MySailAuction.jsp";
		}else if(tab.equals("구매")) {
			buyingList = adbb.getInfoBuying(sessionId);
			buyEndList = adbb.getInfoBuyEnd(sessionId);
			
			String sbingPageNum = request.getParameter("bingPageNum");//페이지 번호  
			if (sbingPageNum == null || sbingPageNum == "") {
				sbingPageNum = "1";
			}
			int bingPageNum = Integer.parseInt(sbingPageNum);
			request.setAttribute("bingPageNum", bingPageNum);
			
			 String sbEndPageNum = request.getParameter("bEndPageNum");//페이지 번호  
			 if (sbEndPageNum == null || sbEndPageNum == "") {
				 sbEndPageNum = "1";
		        }
			int bEndPageNum = Integer.parseInt(sbEndPageNum);
			request.setAttribute("bEndPageNum", bEndPageNum);
			int buyingSize = buyingList.size();
			int buyEndSize = buyEndList.size();
			request.setAttribute("buyingSize", buyingSize);
			request.setAttribute("buyingList", buyingList);
			request.setAttribute("buyEndList", buyEndList);
			request.setAttribute("buyEndSize", buyEndSize);
			myAuction = "/S/MyBuyAuction.jsp";
			
		}else if(tab.equals("관심경매")) {
			interestAucList = adbb.getInfoInterestAuc(sessionId);
			int interestAucSize = interestAucList.size();
			request.setAttribute("interestAucList", interestAucList);
			request.setAttribute("interestAucSize", interestAucSize);
			myAuction = "/S/MyInterestAuction.jsp";
	}
			
		return myAuction;
	}

}
