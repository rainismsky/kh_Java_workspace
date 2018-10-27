package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.ItemDataBean;
import manage.ItemReqDataBean;
import manage.ManageDBBean;
import manage.ScheduleDataBean;
import manage.VacationDataBean;

public class ItemAction implements CommandAction {
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        HttpSession session = request.getSession();
        String real_user = (String)session.getAttribute("real_user");

        ManageDBBean dbPro = ManageDBBean.getInstance();//DBó��
        ArrayList<ItemDataBean> list = dbPro.get_ItemArticle();
        ArrayList<ItemReqDataBean> list2 = dbPro.get_ItemArticleReq();
        ArrayList<ItemReqDataBean> list3 = dbPro.get_MyItemArticleReq(real_user);
        
        int count = dbPro.get_ItemArticleCount();
               
        ServletContext context = request.getSession().getServletContext();
        String realPath = context.getRealPath("fileSave");
        
        request.setAttribute("req_number", 1);
        request.setAttribute("req_number2", 1);
        request.setAttribute("a", count);
        request.setAttribute("list", list);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
        
        return "/administer/Item.jsp";//�ش� ��
    }
}
