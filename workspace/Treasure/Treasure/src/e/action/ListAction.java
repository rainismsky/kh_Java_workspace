package e.action;

import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import e.list.ShowDBBean;
import j.action.CommandAction;

public class ListAction implements CommandAction {//�۸�� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       
    	request.setCharacterEncoding("utf-8");

        String pageNum = request.getParameter("pageNum");//������ ��ȣ
        String l_category_name = request.getParameter("l_category_name");
        String s_category_name = request.getParameter("s_category_name");
      

       
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
        /*String s_category_name = request.getParameter("s_category_name");*/
        List articleList = null;
        ShowDBBean dbPro = ShowDBBean.getInstance();//DB����
        count = dbPro.getArticleCount(s_category_name);//��ü ���� ��
        System.out.println("count" + count);
       
        if (count > 0) {
            articleList = dbPro.getArticles(startRow, endRow, s_category_name);//���� �������� �ش��ϴ� �� ���
        } else {
            articleList = Collections.EMPTY_LIST;
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
        request.setAttribute("s_category_name", s_category_name);
       /*System.out.println("����Ʈ ���� " + articleList.size());*/
        return "/E/list.jsp";//�ش� ��
    }
}