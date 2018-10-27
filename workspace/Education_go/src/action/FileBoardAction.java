package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class FileBoardAction implements CommandAction {
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String pageNum = request.getParameter("pageNum");//������ ��ȣ
    	String search =  request.getParameter("search");
    	String string =  request.getParameter("string");
        
        if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 3;//�� �������� ���� ����
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
        int count = 0;
        int number=0; 

        
        
        List articleList = null;
        ManageDBBean dbPro = ManageDBBean.getInstance();//DB����
        
        
        if(search==null) { // ��ġ�� ������
        	count = dbPro.getFileBoardCount(); // ��ü �� ��
        	if(count > 0) {
        		articleList = dbPro.getFileBoardlist(startRow, endRow);//���� �������� �ش��ϴ� �� ���
        	} else {
                articleList = Collections.EMPTY_LIST;
            }
        } else { // ��ġ�� ������
        	count = dbPro.getFileBoardCount(search, string);
        	if(count > 0) {
        		articleList = dbPro.getFileBoardlist(startRow, endRow, search, string);
        	}
        }

        number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
        //�ش� �信�� ����� �Ӽ� �信�� �������̸� �� �¾�Ʈ����Ʈ�� �����������.
        request.setAttribute("currentPage", new Integer(currentPage)); // ��Ƽ�� �����൵ �ڵ����� �ٲ��� ��
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
        
        return "/administer/FileBoard.jsp";//�ش� ��
    }
}
