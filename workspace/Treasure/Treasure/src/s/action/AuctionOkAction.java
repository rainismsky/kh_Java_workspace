package s.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import s.bean.AuctionDBBean;

public class AuctionOkAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");
		int show_no = Integer.parseInt(request.getParameter("show_no"));
		AuctionDBBean adbb = AuctionDBBean.getInstance();
		
		int auc_sp = Integer.parseInt(request.getParameter("auc_sp"));
		int auc_unit = Integer.parseInt(request.getParameter("auc_unit"));
		
		Timestamp auc_end = Timestamp.valueOf(request.getParameter("auc_endDay") + " " + request.getParameter("auc_endTime") + ":00");
		Timestamp auc_start = Timestamp.valueOf(request.getParameter("auc_start") + " 00:00:00");		
		adbb.insertAuc(sessionId, show_no, auc_sp, auc_unit, auc_end, auc_start);
		ArrayList aucOkList = new ArrayList();
		aucOkList = adbb.getInfoAucOk(sessionId);
		
		request.setAttribute("aucOkList", aucOkList);
		
	
		return "/S/MyAucOkAuction.jsp";
	}

}
