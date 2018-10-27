package inquiry_action;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.InQuiryDBBean;
import inquiry.InQuiryDataBean;
import notice_action.CommandAction;

public class InQuiryAction implements CommandAction { //�۸�� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       
        String pageNum = request.getParameter("pageNum");//������ ��ȣ

        if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 10;//�� �������� ���� ����
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
        int count = 0; //������ ����
        int number=0;
        
        ArrayList<InQuiryDataBean> articleList = null;
        InQuiryDBBean dbPro = InQuiryDBBean.getInstance();//DB����
        count = dbPro.getArticle_count();
        System.out.println("!!");
        if (count > 0) {
        	articleList = dbPro.getArticlelist(startRow, endRow);//���� �������� �ش��ϴ� �� ���
        } else {
            articleList = (ArrayList<InQuiryDataBean>) Collections.EMPTY_LIST;
        }
        System.out.println("@@");
        for(int i=0; i<articleList.size();i++) {
        	System.out.println(articleList.get(i).getI_content());
        }

        number=count-(currentPage+1)*pageSize;//�� ��Ͽ� ǥ���� �۹�ȣ
        
        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
       
        return "/geunho/inquiry/inquiry_list.jsp";//�ش� ��
    }
}