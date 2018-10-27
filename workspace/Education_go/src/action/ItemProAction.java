package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.ItemReqDataBean;
import manage.ManageDBBean;

public class ItemProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");

		ManageDBBean dbPro = ManageDBBean.getInstance();// DB����
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String today = mSimpleDateFormat.format(date1);
			
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 7);  // 7�ϵ� ��¥
		Date date2 = cal.getTime();
		String after = mSimpleDateFormat.format(date2);
	
		String str = request.getParameter("item_name");
		String item_name = str.substring(0, str.length()-1);
		String item_count = request.getParameter("item_count");
        HttpSession session = request.getSession();
        String real_user = (String)session.getAttribute("real_user");
	
        String t_name = dbPro.get_t_name(real_user);

        ItemReqDataBean article = new ItemReqDataBean();
        article.setItem_name(item_name);
        article.setItem_req_count(Integer.parseInt(item_count));
        article.setItem_start(today);
        article.setItem_end(after);
        article.setT_id(real_user);
        
		dbPro.modify_ItemReqArticle_minus(item_name, Integer.parseInt(item_count)); // ��ǰ �� ����
		dbPro.insert_ItemReqArticle(article); // �뿩��Ͽ� ����
		dbPro.insert_ItemReqArticle1(article); // �뿩��Ͽ� ����
		System.out.println("adsf");
		
		return "/administer/ItemPro.jsp";
	}

}
