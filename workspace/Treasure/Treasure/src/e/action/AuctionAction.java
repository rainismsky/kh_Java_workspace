package e.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import e.list.AuctionDBBean;
import j.action.CommandAction;


public class AuctionAction implements CommandAction {//�۸�� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       
        String pageNum = request.getParameter("pageNum");//������ ��ȣ
        String l_category_name = request.getParameter("l_category_name");
        
        if (pageNum == null) {
            pageNum = "1";
        }
        System.out.println(pageNum);
        int pageSize = 9;//�� �������� ���� ����
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
        int count = 0;
        int number=0;
 /*       String l_category_name = request.getParameter("Creative Arts");*/
        List articleList = null;
        AuctionDBBean dbPro = AuctionDBBean.getInstance();//DB����
        count = dbPro.getArticleCount(l_category_name);//��ü ���� ��
        System.out.println("count" + count);
        
       
        if (count > 0) {
            articleList = dbPro.getArticles(startRow, endRow, l_category_name);//���� �������� �ش��ϴ� �� ���
            System.out.println("if");
        } else {
            articleList = Collections.EMPTY_LIST;
            System.out.println("else");
        }

	number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
	request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
        request.setAttribute("l_category_name", l_category_name);
       System.out.println("count" +count);
/*       System.out.println("����ũ ���� " + articleList.size());*/
        return "/E/auctionList.jsp";//�ش� ��
    }
}